package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import index.DButil;
import model.Candidate;
import model.Certificate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class SelectData {
	private static List<Candidate> selectListCandidate(Connection conn) {
		List<Candidate> listCandidate = new ArrayList<>();
		
		String stateString = "SELECT * FROM dbo.TAB_CANDIDATE";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(stateString);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Candidate obj = null;
				if (rs.getString("candidateType").equals("0")) {
					obj = selectExperience(rs);
				}
				if (rs.getString("candidateType").equals("1")) {
					obj = selectFresher(rs);
				}
				if (rs.getString("candidateType").equals("2")) {
					obj = selectIntern(rs);
				}
				listCandidate.add(obj);
			}

			return listCandidate;
		} catch (Exception e) {
			System.out.println("Co loi xay ra" + e);
			return listCandidate;
		} finally {
			DButil.closeState(stmt);
		}
	}

	private static void selectCandidate(ResultSet rs, Candidate obj) throws SQLException {
		obj.setCandidateID(rs.getString("candidateID"));
		obj.setFullName(rs.getString("fullName"));
		obj.setBirthDay(LocalDate.parse(rs.getString("birthDay")));
		obj.setPhone(rs.getString("phone"));
		obj.setEmail(rs.getString("email"));
	}

	private static Candidate selectExperience(ResultSet rs) throws SQLException {
		Candidate obj = new Experience();
		selectCandidate(rs, obj);
		((Experience) obj).setExpInYear(rs.getInt("expInYear"));
		((Experience) obj).setProSkill(rs.getString("proSkill"));

		return obj;
	}

	private static Candidate selectFresher(ResultSet rs) throws SQLException {
		Candidate obj = new Fresher();
		selectCandidate(rs, obj);
		((Fresher) obj).setGraduationDate(LocalDate.parse(rs.getString("graduationDate")));
		((Fresher) obj).setGraduationRank(rs.getString("graduationRank"));
		((Fresher) obj).setEducation(rs.getString("education"));

		return obj;
	}

	private static Candidate selectIntern(ResultSet rs) throws SQLException {
		Candidate obj = new Intern();
		selectCandidate(rs, obj);
		((Intern) obj).setMajors(rs.getString("majors"));
		((Intern) obj).setSemester(rs.getInt("semester"));
		((Intern) obj).setUniversityName(rs.getString("universityName"));

		return obj;
	}

	public static List<Candidate> selectData(Connection conn) {
		List<Candidate> listCandidate = selectListCandidate(conn);
		String sqlQuery = "SELECT * FROM dbo.TAB_CERTIFICATE WHERE CANDIDATEID = ?";
		PreparedStatement stmt = null;
		for (Candidate candi : listCandidate) {
			try {

				stmt = conn.prepareStatement(sqlQuery);
				stmt.setString(1, candi.getCandidateID());
				ResultSet rs = stmt.executeQuery();

				List<Certificate> listCerti = new ArrayList<>();

				while (rs.next()) {
					Certificate certi = new Certificate();
					certi.setCertificatedID(rs.getString("certificatedID"));
					certi.setCertificateName(rs.getString("certificateName"));
					certi.setCertificateRank(rs.getString("certificateRank"));
					certi.setCertificatedDate(LocalDate.parse(rs.getString("certificatedDate")));
					listCerti.add(certi);
				}

				candi.setListCertificate(listCerti);

			} catch (Exception e) {
				System.out.println("Co loi xay ra" + e);
				return listCandidate;
			} finally {
				DButil.closeState(stmt);
			}
		}
		return listCandidate;
	}
}
