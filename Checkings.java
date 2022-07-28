//Checkings Java Class
import java.util.*;
import java.io.*;

class Checkings implements Serializable
{
	public static void main(String args[])
	{

		Scanner input = new Scanner(System.in);
		Checkings account = new Checkings();
		boolean transaction = true;
		while(transaction)
		{
		//System.out.println(account.checkBalance());
		System.out.println("Welcome, make a selection: \n");
		System.out.println("1) Check Balance ");
		System.out.println("2) Make deposit ");
		System.out.println("3) Make withdrawal ");
		System.out.println("4) Exit ");
		int selection = input.nextInt();
		//boolean transaction = true;

		switch(selection)
		{
		case 1:
			System.out.println("Your balance is: "+account.checkBalance());
			break;
		case 2:
			System.out.println("How much would you like to deposit?");
		       	double deposit = input.nextDouble();
			account.makeDeposit(deposit);
			System.out.println("Your new balance is : $"+account.checkBalance());
			break;
		case 3:
			System.out.println("How much would you like to withdraw?");
			double withdrawal = input.nextDouble();
			account.makeWithdrawal(withdrawal);
			System.out.println("Your new balance is : $"+account.checkBalance());
			break;
		case 4:
			transaction = false;
		}
		}
	}//main

	private double balance;

	public void makeDeposit(double deposit)
	{
		balance += deposit;
		//System.out.println("Your current balance is: ");
		//System.out.println(balance);
	}//deposit method

	public void makeWithdrawal(double withdrawal)
	{
		if(withdrawal > balance)
		{
			System.out.println("There aren't enough funds in your account.");
		}//if statement
		else
		balance -= withdrawal;
	}//withdrawal method

	public double checkBalance()
	{
		return balance;
	}//getter

	void setBalance(double balance)
	{
		this.balance = balance;
	}

}//end of class
