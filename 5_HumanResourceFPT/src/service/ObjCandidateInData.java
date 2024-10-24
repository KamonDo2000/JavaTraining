package service;

import java.sql.Connection;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import view.InputData;
import view.Menu;

public class ObjCandidateInData {
	public static Candidate input(Connection conn) {
		switch (Menu.inputMenu()) {
		case 1:
			return inExperience(conn);
		case 2:
			return inFresher(conn);
		case 3:
			return inIntern(conn);
		default:
			break;
		}
		return null;
	}

	private static void inputCandidate(Candidate candi, Connection conn) {

		do {
			String id = InputData.inCandidateID();
			if (!SearchService.searchByID(conn, id)) {
				System.err.println("ID not already, please retype!!");
				continue;
			}
			candi.setCandidateID(id);
			break;
		} while (true);

		candi.setFullName(InputData.inFullName());
		candi.setBirthDay(InputData.inBirthDay());
		candi.setPhone(InputData.inPhone());
		candi.setEmail(InputData.inEmail());
	}

	private static Experience inExperience(Connection conn) {
		Candidate candi = new Experience();

		inputCandidate(candi, conn);
		((Experience) candi).setExpInYear(InputData.inExpInYear());
		((Experience) candi).setProSkill(InputData.inProSkill());

		return ((Experience) candi);
	}

	private static Fresher inFresher(Connection conn) {
		Candidate candi = new Fresher();

		inputCandidate(candi, conn);
		((Fresher) candi).setGraduationDate(InputData.inGraduationDate());
		((Fresher) candi).setGraduationRank(InputData.inGraduationRank());
		((Fresher) candi).setEducation(InputData.inEducation());

		return ((Fresher) candi);
	}

	private static Intern inIntern(Connection conn) {
		Candidate candi = new Intern();

		inputCandidate(candi, conn);
		((Intern) candi).setMajors(InputData.inMajors());
		((Intern) candi).setSemester(InputData.inSemester());
		((Intern) candi).setUniversityName(InputData.inUniversityName());

		return ((Intern) candi);
	}
}
