//filePath.java
import java.io.*;
import java.util.*;

public class filePath
{
	public static void main(String args[])
	{
		File file = new File("Accounts.txt");
		System.out.println("File path is : "+file.getAbsolutePath());

		if(file.exists())
		{
			System.out.println("It also exists in the directory");
		}


	}
}
