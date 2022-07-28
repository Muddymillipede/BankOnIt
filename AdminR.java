//AdminR.java
import java.io.*;
import java.util.*;

public class AdminR
{
	public static void main(String[] args)
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<>();
		File file = new File("Accounts.dat");
		AdminR admin = new AdminR();
		Scanner input = new Scanner(System.in);
		try
		{
			//File file = new File("Accounts.dat");
			if(!file.exists())
			{
				file.createNewFile();
				FileOutputStream oFile = new FileOutputStream("Accounts.dat");
				ObjectOutputStream oObject = new ObjectOutputStream(oFile);
				oObject.writeObject(arrayOfUsers);
			}
			FileInputStream iFile = new FileInputStream(file);
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			boolean selecting = true;
			while(selecting)
			{
			System.out.println("Welcome to RETH Bank. What would you like to do today?");
			System.out.println("1)Add User");
			System.out.println("2)Delete User");
			System.out.println("3)List all users");
			System.out.println("4)exit");
			int selection = input.nextInt();
			switch (selection)
			{
			case 1:
				admin.addUser();
				break;
			case 2:
				admin.deleteUser();
				break;
			case 3:
				admin.listAllUsers();
				break;
			case 4:
				selecting = false;
				
			}//end switch
			}
		}
		catch(FileNotFoundException fnfe){System.out.println("File not found");}
		catch(IOException ioe){System.out.println("Input not found");}
		/*catch(FileNotFoundException fnfe){System.out.println("File not found");}*/




	}//end of main

	void addUser()
	{
		File file = new File("Accounts.dat");
		Scanner input = new Scanner(System.in);
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		System.out.println("Enter the account number: ");
		try
		{
			String accountNumberEntered = input.nextLine();
			if(!file.exists())
			{
				file.createNewFile();
				FileOutputStream oFile = new FileOutputStream(file);
				ObjectOutputStream oObject = new ObjectOutputStream(oFile);
				oObject.writeObject(arrayOfUsers);
				oObject.close();
				oFile.close();
			}//end if statement
			FileInputStream iFile = new FileInputStream(file);
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			user.setAccountNumber(accountNumberEntered);
			arrayOfUsers.add(user);

			FileOutputStream oFile = new FileOutputStream(file);
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);


			System.out.println("Account number "+accountNumberEntered+" successfully added");

		}
		catch(IOException ioe){System.out.println("Input not found");}
		/*catch(FileNotFoundException fnfe){System.out.println("File not found");}*/
		/*catch(ObjectNotFoundException onfe){System.out.println("Input not found");}*/
	}//end add user

	void deleteUser()
	{
		File file = new File("Accounts.dat");
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		Scanner input = new Scanner(System.in);
		System.out.println("Which user would you like to delete?");
		try
		{
			String accountNumberForDeletion = input.nextLine();
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
			arrayOfUsers = (ArrayList) iObject.readObject();
			if(arrayOfUsers.size() != 0)
			{
				boolean accountNumberNotFound = true;
				int counter = 0;
			do
			{
				user = arrayOfUsers.get(counter);
				if(accountNumberForDeletion.equals(user.getAccountNumber()))
				{
					arrayOfUsers.remove(counter);
					FileOutputStream oFile = new FileOutputStream(file);
					ObjectOutputStream oObject = new ObjectOutputStream(oFile);
					oObject.writeObject(arrayOfUsers);

					oObject.close();
					oFile.close();
				}//end of if
				counter++;
			}while(accountNumberNotFound);//end of do-while
			iObject.close();
			iFile.close();
			}//end of if
			else
			{
				System.out.println("There are no account numbers in existence yet.");
			}//end of else

		}//end of try
		catch(IOException ioe){System.out.println("Input not found or given");}
		catch(ClassNotFoundException cnfe){System.out.println("Class not found");}

	}//end of deleteUser

	void listAllUsers()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users user = new Users();
		File file = new File("Accounts.dat");


	try
	{
		FileInputStream iFile = new FileInputStream(file);
		ObjectInputStream iObject = new ObjectInputStream(iFile);
		arrayOfUsers = (ArrayList) iObject.readObject();

		System.out.println("The current number of users is  "+arrayOfUsers.size()+". This is the list:");
		String stop = input.nextLine();
		boolean accountNumbersInFile = true;
		int counter = 1;
		do
		{
			if(arrayOfUsers.size() != 0)
			{
			if(counter == arrayOfUsers.size())
			{
				accountNumbersInFile = false;

			}else
			{
				user = arrayOfUsers.get(counter-1);
				System.out.println(user.getAccountNumber());
			}

			}
			counter++;
		}while(accountNumbersInFile);
		FileOutputStream oFile = new FileOutputStream(file);
		ObjectOutputStream oObject = new ObjectOutputStream(oFile);
		oObject.writeObject(arrayOfUsers);
	}
	catch(IOException ioe){System.out.println("Input not found");}
	catch(ClassNotFoundException cnfe){System.out.println("Class not found");}
	}//end of listAllUsers

	void applyInterestToSavingsAccounts()
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<>();
		Users user = new Users();
		File file = new File("Accounts.dat");
		try
		{
		if(!file.exists())
		{
			file.createNewFile()
		}

		if(arrayOfUsers.size() != 0)
		{
		FileInputStream iFile = new FileInputStream(file);
		ObjectInputStream iObject = new ObjectInputStream(iFile);

		arrayOfUsers = (ArrayList) iObject.readObject();
		
		for(int i = 0;i <= arrayOfUsers.size();i++)
		{
			user = arrayOfUsers.get(i);
			System.out.println(user.getPrinciple());
			user.calculateInterest(1);
			System.out.println(user.getPrinciple());
		}//end of for loop
			FileOutputStream oFile = new FileOutputStream(file);
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);
			iObject.close();
			iFile.close();
			oObject.close();
			oFile.close();
		}
		catch(IOException ioe){System.out.println("Input not found");}
		catch(ClassNotFoundException cnfe){System.out.println("Class not found");}


		System.out.println("Interest has been applied to all accounts!");
		}
		else
		{
			System.out.println("There are no accounts stored);
		}
	}//end of applyInterestToAllSavingsAccounts
		
}//end of class
