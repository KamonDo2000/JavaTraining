package controler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Candidate;
import model.Certificate;
import model.Experience;
import model.Fresher;
import model.Intern;
import service.SearchService;
import view.InputData;
import view.Menu;

public class InputCandidateControl {
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
			if (SearchService.searchByID(conn, id)) {
				System.err.println("ID is already, please retype!!");
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

	private static void certificate(Candidate candi, Connection conn) {
		List<Certificate> listCertificate = new ArrayList<>();

		do {
			Certificate cer = new Certificate();

			do {
				String id = InputData.inCertificatedID();
				if (SearchService.searchCertificateByID(conn, id)) {
					System.err.println("ID is already, please retype!!");
					continue;
				}
				cer.setCertificatedID(id);
				break;
			} while (true);

			cer.setCertificateName(InputData.inCertificateName());
			cer.setCertificateRank(InputData.inCertificateRank());
			cer.setCertificatedDate(InputData.inCertificatedDate());
			listCertificate.add(cer);
			if (!Menu.checkContinue()) {
				break;
			}
		} while (true);

		candi.setListCertificate(listCertificate);
	}

	private static Experience inExperience(Connection conn) {
		Candidate candi = new Experience();

		inputCandidate(candi, conn);
		((Experience) candi).setExpInYear(InputData.inExpInYear());
		((Experience) candi).setProSkill(InputData.inProSkill());
		certificate(candi, conn);

		return ((Experience) candi);
	}

	private static Fresher inFresher(Connection conn) {
		Candidate candi = new Fresher();

		inputCandidate(candi, conn);
		((Fresher) candi).setGraduationDate(InputData.inGraduationDate());
		((Fresher) candi).setGraduationRank(InputData.inGraduationRank());
		((Fresher) candi).setEducation(InputData.inEducation());
		certificate(candi, conn);

		return ((Fresher) candi);
	}

	private static Intern inIntern(Connection conn) {
		Candidate candi = new Intern();

		inputCandidate(candi, conn);
		((Intern) candi).setMajors(InputData.inMajors());
		((Intern) candi).setSemester(InputData.inSemester());
		((Intern) candi).setUniversityName(InputData.inUniversityName());
		certificate(candi, conn);

		return ((Intern) candi);
	}

}
