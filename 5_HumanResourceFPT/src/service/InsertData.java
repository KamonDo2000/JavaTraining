package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import index.DButil;
import model.Candidate;
import model.Certificate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class InsertData {
	public static void insertCandidate(Connection conn, Candidate candidate) {
		String stateString = "INSERT INTO dbo.TAB_CANDIDATE ("
				+ "candidateID, candidateType, fullName, birthDay, phone, email, expInYear, proSkill, graduationDate"
				+ ", graduationRank, education, majors, semester, universityName)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(stateString);
			
			stmt.setString(1, candidate.getCandidateID());
			stmt.setString(2, candidate.getCandidateType());
			stmt.setString(3, candidate.getFullName());
			stmt.setDate(4, Date.valueOf(candidate.getBirthDay()));
			stmt.setString(5, candidate.getPhone());
			stmt.setString(6, candidate.getEmail());
			stmt.setInt(7, 0);
			stmt.setString(8, null);
			stmt.setDate(9, null);
			stmt.setString(10, null);
			stmt.setString(11, null);
			stmt.setString(12, null);
			stmt.setInt(13, 0);
			stmt.setString(14, null);

			if (candidate instanceof Experience) {
				stmt.setInt(7, ((Experience) candidate).getExpInYear());
				stmt.setString(8, ((Experience) candidate).getProSkill());
			} else if (candidate instanceof Fresher) {
				stmt.setDate(9, Date.valueOf(((Fresher) candidate).getGraduationDate()));
				stmt.setString(10, ((Fresher) candidate).getGraduationRank());
				stmt.setString(11, ((Fresher) candidate).getEducation());
			} else {
				stmt.setString(12, ((Intern) candidate).getMajors());
				stmt.setInt(13, ((Intern) candidate).getSemester());
				stmt.setString(14, ((Intern) candidate).getUniversityName());
			}

			stmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Insert Success Candidate!!");
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}

		insertCertificate(conn, candidate);

	}

	private static void insertCertificate(Connection conn, Candidate candidate) {
		String stateString = "INSERT INTO dbo.TAB_CERTIFICATE"
				+ "(certificatedID,candidateID,certificateName,certificateRank,certificatedDate) VALUES(?,?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(stateString);
			conn.setAutoCommit(false);

			for (Certificate certi : candidate.getListCertificate()) {
				stmt.setString(1, certi.getCertificatedID());
				stmt.setString(2, candidate.getCandidateID());
				stmt.setString(3, certi.getCertificateName());
				stmt.setString(4, certi.getCertificateRank());
				stmt.setDate(5, Date.valueOf(certi.getCertificatedDate()));

				stmt.addBatch();
			}

			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Insert Success Certificate!!");
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

}
