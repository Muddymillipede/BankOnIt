//Admin Java

import java.io.*;
import java.util.*;

public class Admin extends Users implements Serializable
{
	public static void main(String args[])
	{
		System.out.println("Hello world");
	}
	protected int numberOfUsers;

	public void addUser()
	{
		Scanner input = new Scanner(System.in);
		//User newUser[numberOfUsers] = new User();
		ArrayList<User> arrayOfUsers = new ArrayList<User>();
		System.out.println("Please enter a 5-digit account number: ");
		String accountNumberStr = input.nextLine();
		//int ac
		//countNUmberInt = Integer.parseInt();
		newUser[numberOfUsers].setAccountNumber(accountNumberStr);
		FileOutputStream wFile = new FileOutputStream("Accounts.dat");
		ObjectOutputStream wObject = new ObjectOutputStream(wFile);
		wObject.writeObject(newUser);



	}

	public void deleteUser()
	{
	}

	public void listUsers()
	{
	}

	public void applyInterest()
	{
	}

}//class end
