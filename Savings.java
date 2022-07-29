//Savings Class

import java.util.*;
import java.io.*;

public class Savings extends Checkings implements Serializable
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		Savings savingsAccount = new Savings();
		System.out.println("This is your balance: $"+savingsAccount.checkBalance());
		System.out.println("Please enter a deposit: \n$");
		double principle = input.nextDouble();
		savingsAccount.makeDeposit(principle);
		
	}
	private double principle;
	private double interestRate = 1.01;	
	private double period = 1;
	//private double interest;


	/*double getInterest()
	{
		return interest;
	}*/

	double calculateInterest(double balance)
	{
		principle = balance;
		double interestC = principle*(1+interestRate*period);
		principle  = interestC;
		return principle;
	}

	/*void setInterest(double interest)
	{
		this.interest = interest;
	}*/

	void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}

	double getInterestRate(double interestRate)
	{
		return interestRate;
	}

	void setPeriod(int period)
	{
		this.period = period;
	}

	double getPeriod()
	{
		return period;
	}

/*	void setPrinciple(double principle)
	{
		this.principle+=principle;
	}

	double getPrinciple()
	{
		return principle;
	}
*/
	/*void applyInterest()
	{
		interest = principle*(1+interestRate*period);
	}*/

}//end class

