//LogIn.java

import java.io.*;
import java.util.*;

public class LogIn
{
	static final String ADMIN_ACCOUNT_NUMBER = "00000";
	public static void main(String args[])
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<Users>();
		Scanner input = new Scanner(System.in);
		Users currentUser = new Users();
		System.out.println("Welcome to RETH Bank.\nPlease enter your Account Number:");
		String accountNumberEntered = input.nextLine();
		try
		{
			FileInputStream iFile = new FileInputStream("Accounts.dat");
			ObjectInputStream iObject = new ObjectInputStream(iFile);
			arrayOfUsers =(ArrayList<Users>) iObject.readObject();


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
		boolean condition = true;
		do
		{
			System.out.println(accountNumberEntered);
			if(accountNumberEntered.equals(ADMIN_ACCOUNT_NUMBER))
			{
				System.out.println("Enter 5-digit PIN: ");
				String enteredPIN = input.nextLine();
				if(enteredPIN.equals("12345"))
				{
					//HERE GOES THE ADMIN MENU
					condition = false;
				}
				else for (int i = 3;i >= 1;i--)
				{
					System.out.println("Incorrect PIN. "+i+" more tries before extermination: ");
					input.nextLine();
					if(enteredPIN == "12345")
					{
						//HERE GOES THE ADMIN MENU
						i = 1;
						condition = false;
					}//if end
					if(i == 1)
					{
						System.out.println("Number of tries exceeded. Prepare to be exterminated, bye bye");
						condition = false;
					}
				}//for loop end

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
							condition2 = false;
						}//if end
						i++;
					}//else end

				}while(condition2);
			}//else end
		}while(condition);//while end
	}


}// class end
