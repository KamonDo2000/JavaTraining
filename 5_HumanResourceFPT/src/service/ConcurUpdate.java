package service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class ConcurUpdate {

	public static void updateConcur(Candidate candidate, Connection conn) {

		String sqlString = "SELECT * FROM dbo.TAB_CANDIDATE Where candidateID = '" + candidate.getCandidateID() + "'";
		Statement stmt = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {

				rs.updateString("candidateType", candidate.getCandidateType());
				rs.updateString("fullName", candidate.getFullName());
				rs.updateDate("birthDay", Date.valueOf(candidate.getBirthDay()));
				rs.updateString("phone", candidate.getPhone());
				rs.updateString("email", candidate.getEmail());

				rs.updateInt("expInYear", 0);
				rs.updateString("proSkill", null);
				rs.updateDate("graduationDate", null);
				rs.updateString("graduationRank", null);
				rs.updateString("education", null);
				rs.updateString("majors", null);
				rs.updateInt("semester", 0);
				rs.updateString("universityName", null);

				if (candidate instanceof Experience) {
					rs.updateInt("expInYear", ((Experience) candidate).getExpInYear());
					rs.updateString("proSkill", ((Experience) candidate).getProSkill());
				}

				if (candidate instanceof Fresher) {
					rs.updateDate("graduationDate", Date.valueOf(((Fresher) candidate).getGraduationDate()));
					rs.updateString("graduationRank", ((Fresher) candidate).getGraduationRank());
					rs.updateString("education", ((Fresher) candidate).getEducation());
				}

				if (candidate instanceof Intern) {
					rs.updateString("majors", ((Intern) candidate).getMajors());
					rs.updateInt("semester", ((Intern) candidate).getSemester());
					rs.updateString("universityName", ((Intern) candidate).getUniversityName());
				}

				rs.updateRow();

			}

			System.out.println("Update success!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}