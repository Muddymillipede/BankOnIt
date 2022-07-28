//Admin Java

import java.io.*;
import java.util.*;

public class Admin /*extends Users */implements Serializable
{
	static final String PATH = "/home/pi/JavaPrograms/BankOnIt/Accounts.txt";
	public static void main(String args[])
	{
		File file = new File("Accounts.dat");
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
		}
	}
	protected int numberOfUsers;
	//protected ArrayList<Users> arrayOfUsers = new ArrayList<Users>();

	int getNOU()
	{
		return numberOfUsers;
	}
	
	public void addUser()
	{
		File file = new File("Accounts.dat");
		Scanner input = new Scanner(System.in);
		Users newUser = new Users();
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		System.out.println("Please enter a 5-digit account number: ");
		String accountNumberStr = input.nextLine();
		//countNUmberInt = Integer.parseInt();
		newUser.setAccountNumber(accountNumberStr);
		System.out.println("Please now enter a 5-digit pin for the account: ");
		String PINStr = input.nextLine();
		newUser.setPIN(PINStr);
		try{
		if(!file.exists())
		{
			file.createNewFile();
			FileOutputStream oFile = new FileOutputStream(file);
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);
			oObject.close();
			oFile.close();
		}
		FileInputStream iFile = new FileInputStream(file);
		ObjectInputStream iObject = new ObjectInputStream(iFile);
		
		arrayOfUsers = (ArrayList<Users>)iObject.readObject();
		arrayOfUsers.add(newUser);	

		FileOutputStream oFile = new FileOutputStream(file);
		ObjectOutputStream oObject = new ObjectOutputStream(oFile);
		oObject.writeObject(arrayOfUsers);

		oObject.close();
		oFile.close();
		iFile.close();
		iObject.close();
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

	public void deleteUser()
	{
		File file = new File("Accounts.dat");
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users currentUser = new Users();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Account Number that you would like to delete:");
		try{
		int accountNumberforDeletion = input.nextInt();
		FileInputStream iFile = new FileInputStream(file);
		ObjectInputStream iObject = new ObjectInputStream(iFile);

		arrayOfUsers = (ArrayList<Users>) iObject.readObject();
		boolean condition = true;
		int i = 0;
		do
		{
			if(i == arrayOfUsers.size())
			{
				System.out.println("That account number does not exist");
				condition = false;
			}else
			{
				currentUser = arrayOfUsers.get(i);
				if(currentUser.getAccountNumber() == accountNumberforDeletion && currentUser.checkCheckingsBalance() == 0.00 && currentUser.checkSavingsBalance() == 0.00)
				{
					arrayOfUsers.remove(i);
					System.out.println("Account "+accountNumberforDeletion +" was succesfully removed from the system");
					condition = false;


				}
				else
				{
					System.out.println("The account "+accountNumberforDeletion+" still has funds and can't be erased");
				}
			}	
			i++;
		}
		while(condition);
		FileOutputStream oFile = new FileOutputStream(file);
		ObjectOutputStream oObject = new ObjectOutputStream(oFile);
		oObject.writeObject(arrayOfUsers);

		iObject.close();
		iFile.close();
		oObject.close();
		oFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}
		catch(ClassNotFoundException ioe){System.out.println("Class not found exception Exception");}
		//numberOfUsers--;
	}

	public void listUsers()
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users currentUser = new Users();
		//Scanner input = new Scanner(System.in);
		System.out.println("These are the existing accounts: ");
		try{
		//int accountNumberforDeletion = input.nextInt();
		FileInputStream iFile = new FileInputStream("Accounts.dat");
		ObjectInputStream iObject = new ObjectInputStream(iFile);

		arrayOfUsers = (ArrayList<Users>) iObject.readObject();
		//System.out.println("These are the current accounts: ");
		System.out.println("Current number of accounts: "+arrayOfUsers.size());
		boolean condition = true;
		int i = 0;
		do 	
		{
			if(i == arrayOfUsers.size())
			{
				condition = false;
			}else
			{
			currentUser = arrayOfUsers.get(i);
			System.out.println("\n"+currentUser.getAccountNumber());

			i++;
			}
		}while(condition);


		iObject.close();
		iFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}
		catch(ClassNotFoundException ioe){System.out.println("IO Exception");}


	}

	public void applyInterest()
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<>();
		Users user = new Users();
		File file = new File("Accounts.dat");
		try
		{
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileInputStream iFile = new FileInputStream(file);
		ObjectInputStream iObject = new ObjectInputStream(iFile);

		arrayOfUsers = (ArrayList) iObject.readObject();	
		if(arrayOfUsers.size() != 0)
		{
		for(int i = 0;i < arrayOfUsers.size();i++)
		{
			user = arrayOfUsers.get(i);
			System.out.println(user.checkSavingsBalance());
			user.calculateInterest(1);
			System.out.println(user.checkSavingsBalance());
		}//end of for loop
			FileOutputStream oFile = new FileOutputStream(file);
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);
			iObject.close();
			iFile.close();
			oObject.close();
			oFile.close();



		System.out.println("Interest has been applied to all accounts!");
		}
		else
		{
			System.out.println("There are no accounts stored");
		}


		}
		catch(IOException ioe){System.out.println("Input not found");}
		catch(ClassNotFoundException cnfe){System.out.println("Class not found");}
	}

}//class end
