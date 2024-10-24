package controler;

import java.util.List;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class ShowCandidateControl {

	public static void show(List<Candidate> listCandidate) {
		for (Candidate candi : listCandidate) {
			if (candi instanceof Experience) {
				candi.showInfo();
			}
			if (candi instanceof Fresher) {
				candi.showInfo();
			}
			if (candi instanceof Intern) {
				candi.showInfo();
			}
		}
	}

	public static void showCountCandidate(List<Candidate> listCandidate) {
		System.out.println("\n======================================");
		System.out.print("Quantity the Candidate last input: ");
		System.out.println(listCandidate.get(listCandidate.size() - 1).getCanidateCount());
	}

	public static void showFullName(List<Candidate> listCandidate) {
		StringBuffer strB = new StringBuffer();

		for (Candidate candi : listCandidate) {
			String name = candi.getFullName() + ", ";
			strB.append(name);
		}

		System.out.println(strB.toString());
	}

}
