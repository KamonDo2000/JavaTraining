package model;

public class SavingsAccount {

	double annualInterestRate;// số lãi hàng năm
	double savingsBalance; // số dư tiết kiệm

	public SavingsAccount() {
		super();
		this.annualInterestRate = 0;
		this.savingsBalance = 0;
	}

	public SavingsAccount(double intRate, double savBal) {
		super();
		this.annualInterestRate = intRate;
		this.savingsBalance = savBal;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double calculateMonthlyInterest() {
		savingsBalance += (savingsBalance * annualInterestRate) / 12;
		return (savingsBalance * annualInterestRate) / 12;
	}

}
