//LogIn.java

import java.io.*;
import java.util.*;

public class LogIn
{
	static final String PATH = "/home/pi/JavaPrograms/BankOnIt/Accounts.dat";
	static final String ADMIN_ACCOUNT_NUMBER = "00000";
	public static void main(String args[])
	{
		File accounts = new File("Accounts.dat");
		LogIn login = new LogIn();
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Scanner input = new Scanner(System.in);
		Users currentUser = new Users();
		System.out.println("Welcome to RETH Bank.\nPlease enter your Account Number:");
		String accountNumberEntered = input.nextLine();
		try
		{
			if(!accounts.exists())
			{
				accounts.createNewFile();
				FileOutputStream oFile = new FileOutputStream("Accounts.dat");
				ObjectOutputStream oObject = new ObjectOutputStream(oFile);
				oObject.writeObject(arrayOfUsers);
				oFile.close();
			}
			
	

			FileInputStream iFile = new FileInputStream("Accounts.dat");
			//System.out.println("Error occurs here");
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			arrayOfUsers =(ArrayList<Users>) iObject.readObject();
			


		boolean condition = true;
		do
		{
			//System.out.println(accountNumberEntered);
			if(accountNumberEntered.equals(ADMIN_ACCOUNT_NUMBER))
			{
				System.out.println("Enter 5-digit PIN: ");
				String enteredPIN = input.nextLine();
				if(enteredPIN.equals("12345"))
				{
					login.adminMenu();
					condition = false;
				}
				else
				{
				int i = 3;	
				boolean wrongPassword = true;
				while(wrongPassword)
				{
					System.out.println("Incorrect PIN. "+i+" more tries before extermination: ");
					input.nextLine();
					if(enteredPIN == "12345")
					{
						login.adminMenu();
						i = 1;
						condition = false;
						wrongPassword = false;
					}//if end
					else
					if(i == 1)
					{
						System.out.println("Number of tries exceeded. Prepare to be exterminated, bye bye");
						condition = false;
						wrongPassword = false;
					}

					i--;
				}//while loop
				}//else end

			}//if end
			else 
			{
				int i = 0;
				boolean condition2 = true;
				do
				{
					if(i == arrayOfUsers.size())
					{
						System.out.println("Account Number not found. ATM will explode now. Bye Bye");
						condition = false;
						condition2 = false;
					}//if end
					else
					{
						currentUser = arrayOfUsers.get(i);
						if (Integer.parseInt(accountNumberEntered) == currentUser.getAccountNumber())
						{
							login.userMenu(i);
							condition = false;
							condition2 = false;
						}//if end
						i++;
					}//else end

				}while(condition2);
			}//else end
		}while(condition);//while end
		iObject.close();
		iFile.close();

		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found fnfe");
		}
		catch(IOException ioe)
		{
			System.out.println("File not found ioe");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}
	}

	void adminMenu()
	{
		Scanner input = new Scanner(System.in);
		Users user = new Users();
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Admin newAdmin = new Admin();
		boolean condition = true;
		int selection = 0;
		while(condition)
		{
			System.out.println("Welcome, enter a selection:");
			System.out.println("1) Add user");
			System.out.println("2) Delete user");
			System.out.println("3) List All Users");
			System.out.println("4) Apply Interest");
			System.out.println("5) Exit");

		//	System.out.println("Current Number of Users is: "+ newAdmin.getNOU());
			selection = input.nextInt();
			switch (selection)
			{
			case 1:
			newAdmin.addUser();
			break;
			case 2:
			newAdmin.deleteUser();
			break;
			case 3:
			newAdmin.listUsers();
			break;
			case 4:
			newAdmin.applyInterest();
			break;
			case 5:
			condition = false;
			break;
			}
		//condition = false;
		}//end while

	}//end adminMenu

	void userMenu(int i)
	{
		LogIn login = new LogIn();
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		do
		{

		System.out.println("Which account would you like to work with?");
		System.out.println("1)Checkings Account");
		System.out.println("2)Savings Account");
		System.out.println("3)Exit");
		//System.out.println("4)Exit");
		int selection = input.nextInt();
/*
		try
		{
			FileInputStream iFile = new FileInputStream("Accounts.dat");
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			arrayOfUsers = (ArrayList<Users>) iObject.readObject();
			
			iObject.close();
			iFile.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found fnfe");
		}
		catch(IOException ioe)
		{
			System.out.println("File not found ioe");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}*/
		//user = arrayOfUsers.get(i);
		switch (selection)
		{
			case 1:
/*				System.out.println("How much would you like to deposit?");
				double deposit = input.nextDouble();
				user.makeDeposit(deposit);
				System.out.println("Your new balance is: $"+user.checkBalance());*/
				login.checkingsMenu(i);
				break;
			case 2:
/*				System.out.println("How much would you like to withdraw?");
				double withdrawal = input.nextDouble();
				user.makeWithdrawal(withdrawal);
				System.out.println("Your new balance is: $"+user.checkBalance());*/
				login.savingsMenu(i);
				break;
			case 3:
/*				System.out.println("Your current balance is: $"+user.checkBalance());*/
				condition = false;
				break;
/*			case 4:
				condition = false;*/

		}
		//condition = false;
/*		try
		{	
			FileOutputStream oFile = new FileOutputStream("Accounts.dat");
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);

			//iObject.close();
			//iFile.close();
			oObject.close();
			oFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}*/
		/*catch(ClassNotFoundException ioe){System.out.println("IO Exception");}*/

		}while(condition);
		System.out.println("Thank you for using RETH bank services");
	}//userMenu end

	void checkingsMenu(int i)
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		do
		{

		System.out.println("Please select one of the following options:");
		System.out.println("1)Deposit money into checkings account");
		System.out.println("2)Withdraw money from checkings account");
		System.out.println("3)Check balance on checkings account");
		System.out.println("4)Exit");
		int selection = input.nextInt();

		try
		{
			FileInputStream iFile = new FileInputStream("Accounts.dat");
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			arrayOfUsers = (ArrayList<Users>) iObject.readObject();
			
			iObject.close();
			iFile.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found fnfe");
		}
		catch(IOException ioe)
		{
			System.out.println("File not found ioe");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}
		user = arrayOfUsers.get(i);
		switch (selection)
		{
			case 1:
				System.out.println("How much would you like to deposit?");
				double deposit = input.nextDouble();
				user.makeCheckingsDeposit(deposit);
				System.out.println("Your new balance is: $"+user.checkCheckingsBalance());
			break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				double withdrawal = input.nextDouble();
				user.makeCheckingsWithdrawal(withdrawal);
				System.out.println("Your new balance is: $"+user.checkCheckingsBalance());
				break;
			case 3:
				System.out.println("Your current balance is: $"+user.checkCheckingsBalance());
				break;
			case 4:
				condition = false;

		}
		//condition = false;
		try
		{	
			FileOutputStream oFile = new FileOutputStream("Accounts.dat");
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);

			//iObject.close();
			//iFile.close();
			oObject.close();
			oFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}
		/*catch(ClassNotFoundException ioe){System.out.println("IO Exception");}*/

		}while(condition);
		System.out.println("Thank you for using RETH bank services");

	}//end checkingsMenu

	void savingsMenu(int i)
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		do
		{

		System.out.println("Please select one of the following options:");
		System.out.println("1)Deposit money into savings account");
		System.out.println("2)Withdraw money from savings account");
		System.out.println("3)Check balance on savings account");
		System.out.println("4)Exit");
		int selection = input.nextInt();

		try
		{
			FileInputStream iFile = new FileInputStream("Accounts.dat");
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			arrayOfUsers = (ArrayList<Users>) iObject.readObject();
			
			iObject.close();
			iFile.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found fnfe");
		}
		catch(IOException ioe)
		{
			System.out.println("File not found ioe");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}
		user = arrayOfUsers.get(i);
		switch (selection)
		{
			case 1:
				System.out.println("How much would you like to deposit?");
				double deposit = input.nextDouble();
				user.makeSavingsDeposit(deposit);
				System.out.println("Your new balance is: $"+user.checkSavingsBalance());
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				double withdrawal = input.nextDouble();
				user.makeSavingsWithdrawal(withdrawal);
				System.out.println("Your new balance is: $"+user.checkSavingsBalance());
				break;
			case 3:
				System.out.println("Your current balance is: $"+user.checkSavingsBalance());
				break;
			case 4:
				condition = false;

		}
		//condition = false;
		try
		{	
			FileOutputStream oFile = new FileOutputStream("Accounts.dat");
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);

			//iObject.close();
			//iFile.close();
			oObject.close();
			oFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}
		/*catch(ClassNotFoundException ioe){System.out.println("IO Exception");}*/

		}while(condition);
		System.out.println("Thank you for using RETH bank services");

	}


}// class end
