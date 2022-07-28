//FileRW.java

import java.io.*;
import java.util.*;
public class FileRW
{
	public static void main(String[] args)
	{
		System.out.println("Aloooo");
	}// end main

	ArrayList<Users> readObjectFromFile()
	{
		ArrayList<Users> arrayOfUsers = new ArrayList<>();
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

		return arrayOfUsers;

	}//end readObject

	void writeObjectOnFile(ArrayList<Users> arrayOfUsers)
	{
		try
		{
			FileOutputStream oFile = new FileOutputStream("Accounts.dat");
			ObjectOutputStream oObject = new ObjectOutputStream(oFile);
			oObject.writeObject(arrayOfUsers);
			oObject.close();
			oFile.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found fnfe");
		}
		catch(IOException ioe)
		{
			System.out.println("File not found ioe");
		}
		/*catch(ClassNotFoundException cnfe)
		{
			System.out.println("Class not found");
		}
		*/


	}//end writeObject

}//class end
