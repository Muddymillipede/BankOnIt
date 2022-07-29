//User Class
//
import java.util.*;
import java.io.*;

public class Users implements Serializable
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Hello world");
		System.out.println("Enter 5 numbers: ");
		String accountNumberS = input.nextLine();
		int accountNumberI = Integer.parseInt(accountNumberS);
		System.out.println("Now the number has become an int "+accountNumberI);
	
	}//main


	private int accountNumber;
	private int pin;
	private Checkings checkingsAccount = new Checkings();
	private Savings savingsAccount = new Savings();

	void setAccountNumber(String accountNumber)
	{
		this.accountNumber = Integer.parseInt(accountNumber);
	}

	int getAccountNumber()
	{
		return this.accountNumber;
	}

	void setPIN(String PIN)
	{
		this.pin = Integer.parseInt(PIN);
	}

	int getPIN()
	{
		return this.pin;
	}
	
	void makeCheckingsDeposit(double deposit)
	{
		//Checkings checkingsAccount = new Checkings();
		checkingsAccount.makeDeposit(deposit);
	}

	void makeCheckingsWithdrawal(double withdrawal)
	{
		//Checkings checkingsAccount = new Checkings();
		checkingsAccount.makeWithdrawal(withdrawal);
	}

	double checkCheckingsBalance()
	{
		//Checkings checkingsAccount = new Checkings();
		return checkingsAccount.checkBalance();
	}

	void makeSavingsDeposit(double deposit)
	{
		//Checkings checkingsAccount = new Checkings();
		savingsAccount.makeDeposit(deposit);
	}

	void makeSavingsWithdrawal(double withdrawal)
	{
		//Checkings checkingsAccount = new Checkings();
		savingsAccount.makeWithdrawal(withdrawal);
	}

	double checkSavingsBalance()
	{
		//Checkings checkingsAccount = new Checkings();
		return savingsAccount.checkBalance();
	}


	double calculateInterest(double balance)
	{
		//Savings savingsAccount = new Savings();
		return savingsAccount.calculateInterest(balance);

	}//end calculate interest


	/*void setInterest(double interest)
	{
		this.interest = interest;
	}*/

	void setInterestRate(double interestRate)
	{
		//Savings savingsAccount = new Savings();
		savingsAccount.setInterestRate(interestRate);
	}

	double getInterestRate(double interestRate)
	{
		//Savings savingsAccount = new Savings();		  
		return savingsAccount.getInterestRate(interestRate);
	}

	void setPeriod(int period)
	{
		//Savings savingsAccount = new Savings();
		savingsAccount.setPeriod(period);
	}

	/*double getPeriod()
	{
		Savings savings = new Savings();
		return savings.getPeriod();
	}*/

/*	void setPrinciple(double principle)
	{
		//Savings savingsAccount = new Savings();
		savingsAccount.setPrinciple(principle);
	}

	double getPrinciple()
	{
		//Savings savingsAccount = new Savings();
		return savingsAccount.getPrinciple();
	}*/

}//end class
