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
	private Savings SavingsAccount = new Savings();

	void setAccountNumber(String accountNumber)
	{
		this.accountNumber = Integer.parseInt(accountNumber);
	}

	int getAccountNumber()
	{
		return this.accountNumber;
	}	


}
