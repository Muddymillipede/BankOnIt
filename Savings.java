//Savings Class

import java.util.*;

public class Savings extends Checkings
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		Savings savingsAccount = new Savings();
		System.out.println("This is your balance: $"+savingsAccount.getPrinciple());
		System.out.println("Please enter a deposit: \n$");
		double principle = input.nextDouble();
		savingsAccount.setPrinciple(principle);
		
	}
	private double principle;
	private double interestRate;
	private double period;
	private double interest;


	double getInterest()
	{
		return interest;
	}

	double calculateInterest(int period)
	{
		
		double interestC = principle*(1+interestRate*period);
		return interestC;
	}

	void setInterest(double interest)
	{
		this.interest = interest;
	}

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

	void setPrinciple(double principle)
	{
		this.principle = principle;
	}

	double getPrinciple()
	{
		return principle;
	}

	void applyInterest()
	{
		interest = principle*(1+interestRate*period);
	}

}//end class

