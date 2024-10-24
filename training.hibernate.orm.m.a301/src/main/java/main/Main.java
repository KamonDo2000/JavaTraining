package main;

import java.util.Scanner;

import service.CandidateService;

public class Main {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		do {
			System.out.println("\n");

			System.out.println("1. Add data");
			System.out.println("2. Display list of candidates");
			System.out.println("3. Find all candidate has skill is 'Angluar' and skill level 2");
			System.out.println("4. Find candidates foreign language is 'Japanese' and Skill is Python");
			System.out.println("5. Find all of the candidate by skill is 'Java' and pass entry on '1-Oct-2020'");
			System.out.println("6. Find all of the candidate that pass interview on '15-Oct-2020'");
			System.out.println("7. Update remark is inactive who do not have either phone, email and cv");
			System.out.println("8. Proceed paging operation for Candidate");
			System.out.println("9. Exit");

			System.out.print("Enter the function to proceed: ");
			String choise = sc.nextLine();

			System.out.println("\n");
			switch (choise) {
			case "1":
				CandidateService.insertData();
				break;
			case "2":
				CandidateService.displayListCandidate();
				break;
			case "3":
				CandidateService.findCandidateBySkill();
				break;
			case "4":
				CandidateService.findCandidateByLanguage();
				break;
			case "5":
				CandidateService.findCandidatePassTest();
				break;
			case "6":
				CandidateService.findCandidatePassInterview();
				break;
			case "7":
				CandidateService.updateRemarkCandidate();
				break;
			case "8":
				int pageNum = 2;
				int pageSize = 2;
				CandidateService.displayPagingOperation(pageNum, pageSize);
				break;
			case "9":
				flag = false;
				break;
			default:
				System.out.println("none choose!");
			}
		} while (flag);
	}

}
