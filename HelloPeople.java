
import java.io.Console;
import java.util.Scanner;

public class HelloPeople {
	
	public static void main(String[] args)
	{
		/*
		string x = "Hello peeps!";
		
		System.out.println(x);	
		*/
		
		/*
		string[] commands;
		*/
		 
		String[] commands = new String[] {"clear","list","exit"};
		
		
		while(true)
		{
			/*	java equivilant of string str = Console.ReadLine();
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			*/
			
			Console co=System.console();
			System.out.println(co);
			try
			{
				String str = co.readLine();
			}

			
			
			String spaces = "                            ";
			
			/*
			System.out.println(str);
			System.out.println(spaces);
			*/
			
			if(str == "1")
			{
				System.out.println("You have selected option 1");
				
			}
			else if(str == "2")
			{
				System.out.println("You have selected option 2");
				
			}
			else if(str == "3")
			{
				System.out.println("OPTION 3 is what you choose!");
				
			}
			
			
			/*
			if(str == "list")
			{
				for(String a: commands)
				{
					System.out.println(a);
					
				}
				
			}
			else
			{
				System.out.println(str);
				clearConsole();
			}
			*/
		}
		/*
		System.out.println("Hello peeps!");
		*/
	}
	
	
	
	
	public static void list(String[] args)
	{
		
		
	}
	
	public static void clearConsole()
	{
		System.out.print("\033[H\033[2j");
		System.out.flush();
	}
	
	
	
	public static int addTogether(int A, int B)
	{
		int C = A + B;
		return C;
	}

}
