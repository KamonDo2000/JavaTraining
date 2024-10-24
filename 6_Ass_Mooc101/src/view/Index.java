package view;

import model.SavingsAccount;

public class Index {

	public static void main(String[] args) {

		SavingsAccount saver1 = new SavingsAccount(0.04, 2000.00);
		SavingsAccount saver2 = new SavingsAccount(0.04, 3000.00);

		System.out.println("calculate Monthly Interest: ");
		System.out.println("saver 1: " + saver1.calculateMonthlyInterest());
		System.out.println("saver 2: " + saver2.calculateMonthlyInterest());

		System.out.println("\nNew savings Balance: ");
		System.out.println("saver 1: " + saver1.getSavingsBalance());
		System.out.println("saver 2: " + saver2.getSavingsBalance());
		
		saver1.setAnnualInterestRate(0.05);
		saver2.setAnnualInterestRate(0.05);
		
		System.out.println("\n\n\ncalculate Monthly Interest by 5%: ");
		System.out.println("saver 1: " + saver1.calculateMonthlyInterest());
		System.out.println("saver 2: " + saver2.calculateMonthlyInterest());

		System.out.println("\nNew savings Balance: ");
		System.out.println("saver 1: " + saver1.getSavingsBalance());
		System.out.println("saver 2: " + saver2.getSavingsBalance());

	}

}
