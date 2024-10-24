package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import DAO.CandidateDAO;
import entities.Candidate;
import entities.EntryTest;
import entities.Interview;

public class CandidateService {

	private static Set<String> listErr = new HashSet<>();

	public static void insertData() {

// ===============================================================================================
		Candidate candidate1 = new Candidate("Nguyen Van A", "1990-05-15", 4, "2019/12/20", "1234567890",
				"nguyenvana@gmail.com", "Python", "Japan", 5, "CV1", 1, "Note 1");

		Candidate candidate2 = new Candidate("Tran Thi B", "1992-08-20", 0, "2020/12/20", "0987654321",
				"tranthib@example.com", "Frontend", "English", 6, "CV2", 0, "Note 2");

		Candidate candidate3 = new Candidate("Hoang Anh C", "1988-12-10", 1, "2021/12/20", "1112223333",
				"hoangminhc@gmail.com", "Angular", "Japan", 2, "CV3", 1, "Note 3");

		Candidate candidate4 = new Candidate("Le Thi D", "1995-03-25", 0, "2015/12/20", "", "lethid@example.com",
				"Java", "Korean", 4, "CV4", 0, "Note 4");

		Candidate candidate5 = new Candidate("Nguyen Van H", "1999/12/20", 1, "2020/12/20", "0123456789",
				"hoa@gmail.com", "Angular", "English", 2, "Good", 1, "Note 5");
//===============================================================================================
		EntryTest entryTest1 = new EntryTest("09:00", "2024-04-01", "man language", 14.5, "man technical", 9.0, "pass",
				"Note 1", "test skill 1", candidate1);

		EntryTest entryTest2 = new EntryTest("10:30", "2024-04-02", "man language", 7.5, "man technical", 4.0, "pass",
				"Note 2", "test skill 2", candidate2);

		EntryTest entryTest3 = new EntryTest("13:00", "2020/10/01", "man language", 6.5, "man technical", 7.0, "pass",
				"Note 3", "test skill 3", candidate4);

		EntryTest entryTest4 = new EntryTest("14:30", "2024-04-04", "man language", 5.5, "man technical", 6.0, "fail",
				"Note 4", "test skill 4", candidate3);

		EntryTest entryTest5 = new EntryTest("16:00", "2024-04-05", "man language", 4.5, "man technical", 5.0, "fail",
				"Note 5", "test skill 5", candidate1);
//===============================================================================================
		Interview interview1 = new Interview("09:00", LocalDate.of(2024, 4, 1), "man interview 1", "comment 1", "pass",
				"Note 1", candidate1);

		Interview interview2 = new Interview("10:30", LocalDate.of(2024, 4, 2), "man interview 2", "comment 2", "fail",
				"Note 2", candidate2);

		Interview interview3 = new Interview("13:00", LocalDate.of(2020, 10, 15), "man interview 3", "comment 3",
				"pass", "Note 3", candidate3);

		Interview interview4 = new Interview("14:30", LocalDate.of(2020, 10, 15), "man interview 4", "comment 4",
				"pass", "Note 4", candidate4);

		Interview interview5 = new Interview("16:00", LocalDate.of(2024, 4, 5), "man interview 5", "comment 5", "fail",
				"Note 5", candidate5);
//===============================================================================================
		if (cVal(entryTest1, entryTest1.getCandidate())) {
			CandidateDAO.insertEntryTest(entryTest1);
		}
		if (cVal(entryTest2, entryTest2.getCandidate())) {
			CandidateDAO.insertEntryTest(entryTest2);
		}
		if (cVal(entryTest3, entryTest3.getCandidate())) {
			CandidateDAO.insertEntryTest(entryTest3);
		}
		if (cVal(entryTest4, entryTest4.getCandidate())) {
			CandidateDAO.insertEntryTest(entryTest4);
		}
		if (cVal(entryTest5, entryTest5.getCandidate())) {
			CandidateDAO.insertEntryTest(entryTest5);
		}

		if (bVal(interview1, interview1.getCandidate())) {
			CandidateDAO.insertInterview(interview1);
		}
		if (bVal(interview2, interview2.getCandidate())) {
			CandidateDAO.insertInterview(interview2);
		}
		if (bVal(interview3, interview3.getCandidate())) {
			CandidateDAO.insertInterview(interview3);
		}
		if (bVal(interview4, interview4.getCandidate())) {
			CandidateDAO.insertInterview(interview4);
		}
		if (bVal(interview5, interview5.getCandidate())) {
			CandidateDAO.insertInterview(interview5);
		}

		System.err.println("\n\n");
		listErr.forEach(e -> {
			System.err.println(e);
		});

	}

	private static boolean cVal(EntryTest entry, Candidate candi) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		boolean check = true;
		Set<ConstraintViolation<EntryTest>> violations = validator.validate(entry);
		if (!violations.isEmpty()) {
			for (ConstraintViolation<EntryTest> violation : violations) {
				listErr.add(" EntryTest " + entry.getId() + " : " + violation.getMessage());
			}
			check = false;
		}
		Set<ConstraintViolation<Candidate>> viocan = validator.validate(candi);
		if (!viocan.isEmpty()) {
			for (ConstraintViolation<Candidate> violation : viocan) {
				listErr.add(" Candidate " + candi.getId() + " : " + violation.getMessage());
			}
			check = false;
		}
		return check;
	}

	private static boolean bVal(Interview inter, Candidate candi) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		boolean check = true;

		Set<ConstraintViolation<Interview>> violations = validator.validate(inter);
		if (!violations.isEmpty()) {
			for (ConstraintViolation<Interview> violation : violations) {
				listErr.add(" Interview " + inter.getId() + " : " + violation.getMessage());
			}
			check = false;
		}
		Set<ConstraintViolation<Candidate>> viocan = validator.validate(candi);
		if (!viocan.isEmpty()) {
			for (ConstraintViolation<Candidate> violation : viocan) {
				listErr.add(" Candidate " + candi.getId() + " : " + violation.getMessage());
			}
			check = false;
		}
		return check;
	}

	public static void findCandidateBySkill() {
		List<Candidate> list = CandidateDAO.findCandidateBySkillAndLevel("Angular", 2);
		System.out.println(" **** skill is 'Angluar' and skill level 2 ****");
		for (Candidate candidate : list) {
			System.out.println(candidate.toString());
		}
		if (list.isEmpty()) {
			System.err.println("is not found!");
		}
	}

	public static void findCandidateByLanguage() {
		List<Candidate> list = CandidateDAO.findCandidateByLanguageAndSkill("Japan", "Python");
		System.out.println(" **** foreign language is 'Japanese' and Skill is Python ****");
		for (Candidate candidate : list) {
			System.out.println(candidate.toString());
		}
		if (list.isEmpty()) {
			System.err.println("is not found!");
		}
	}

	public static void findCandidatePassTest() {
//		List<Candidate> list = CandidateDAO.findCandidateBySkillAndPassTest("Java", "2020/10/01");
//		for (Candidate candidate : list) {
//			System.out.println(candidate.toString());
//		}
		List<Object[]> list = CandidateDAO.findCandidateBySkillAndPassTest("Java", "2020/10/01");

		if (list.isEmpty()) {
			System.err.println("is not found!");
		} else {
			list.forEach(e -> {
				String gen;
				if ((Integer) e[1] == 0) {
					gen = "female";
				} else {
					gen = "male";
				}

				System.out.print(e[0] + "  ||  gender: ");
				System.out.print(gen + "  ||  technicalResult: ");
				System.out.println(e[2]);
			});
		}
	}

	public static void findCandidatePassInterview() {
		List<Candidate> list = CandidateDAO.findCandidatePassInterview(LocalDate.of(2020, 10, 15));
		for (Candidate candidate : list) {
			System.out.println(candidate.toString());
		}
		if (list.isEmpty()) {
			System.err.println("is not found!");
		}
	}

	public static void updateRemarkCandidate() {
		List<Candidate> candidates = CandidateDAO.getListCandidate();
		List<Candidate> newListUpdate = new ArrayList<>();
		for (Candidate candidate : candidates) {
			if (candidate.getPhone().trim().isEmpty() || candidate.getEmail().trim().isEmpty()
					|| candidate.getCv().trim().isEmpty()) {
				newListUpdate.add(candidate);
			}
		}
		newListUpdate.forEach(can -> {
			can.setRemark("inActive");
			CandidateDAO.updateRemark(can);
		});
	}

	public static void displayListCandidate() {
		List<Candidate> candidates = CandidateDAO.getListCandidate();
		System.out.println(" **** Show All ****");
		for (Candidate candidate : candidates) {
			System.out.println(candidate);
		}
	}

	public static void displayPagingOperation(int pageNum, int pageSize) {
		List<Candidate> candidates = CandidateDAO.pagingOperation(pageNum, pageSize);
		System.out.println(" **** Show " + pageSize + " record in page " + pageNum + " ****");
		for (Candidate candidate : candidates) {
			System.out.println(candidate);
		}
	}
}
