//Admin Java

import java.io.*;
import java.util.*;

public class Admin /*extends Users */implements Serializable
{
	public static void main(String args[])
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
			case 5:
			condition = false;

			}
		}
		//System.out.println("Hello world");
		//System.out.println(arrayOfUsers.get(1).getAccountNumber());
	/*try{	
		FileInputStream fis = new FileInputStream("Accounts.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		arrayOfUsers = (ArrayList<Users>) ois.readObject();
		//System.out.println(arrayOfUsers.get(0).getAccountNumber());
		user = arrayOfUsers.get(0);
		System.out.println(user.getAccountNumber());

		//wObject.close();
		ois.close();
		//wFile.close();
		fis.close();
	}catch (FileNotFoundException fnfe)
	{
		System.out.println("File Not Found");

	}catch (IOException ioe)
	{
		System.out.println("Input Or Output Not Found");
	}catch (ClassNotFoundException cnfe)
	{
		System.out.println("Object Not Found");

	}*/


	}
	protected int numberOfUsers;
	//protected ArrayList<Users> arrayOfUsers = new ArrayList<Users>();

	int getNOU()
	{
		return numberOfUsers;
	}
	
	public void addUser()
	{
		Scanner input = new Scanner(System.in);
		Users newUser = new Users();
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		System.out.println("Please enter a 5-digit account number: ");
		String accountNumberStr = input.nextLine();
		//countNUmberInt = Integer.parseInt();
		newUser.setAccountNumber(accountNumberStr);
		
		try{
		FileInputStream iFile = new FileInputStream("Accounts.dat");
		ObjectInputStream iObject = new ObjectInputStream(iFile);
		arrayOfUsers = (ArrayList<Users>)iObject.readObject();
		arrayOfUsers.add(newUser);
		//System.out.println("After error message");	

		FileOutputStream oFile = new FileOutputStream("Accounts.dat");
		//System.out.println("Before the error message");
		ObjectOutputStream oObject = new ObjectOutputStream(oFile);
		
		oObject.writeObject(arrayOfUsers);
		//System.out.println("After error message");
		oObject.close();
		oFile.close();
			
		numberOfUsers++;
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

		//wFile.close();
	}

	public void deleteUser()
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Users currentUser = new Users();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Account Number that you would like to delete:");
		try{
		int accountNumberforDeletion = input.nextInt();
		FileInputStream iFile = new FileInputStream("Accounts.dat");
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
				if(currentUser.getAccountNumber() == accountNumberforDeletion)
				{
					arrayOfUsers.remove(i);
					System.out.println("Account "+accountNumberforDeletion +" was succesfully removed from the system");
					numberOfUsers--;
					condition = false;


				}
			}	
			i++;
		}
		while(condition);
		FileOutputStream oFile = new FileOutputStream("Accounts.dat");
		ObjectOutputStream oObject = new ObjectOutputStream(oFile);
		oObject.writeObject(arrayOfUsers);

		iObject.close();
		iFile.close();
		oObject.close();
		oFile.close();
		}
		catch(IOException ioe){System.out.println("IO Exception");}
		catch(ClassNotFoundException ioe){System.out.println("IO Exception");}
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
	}

}//class end
