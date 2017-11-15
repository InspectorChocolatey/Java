import com.nicholasjacquet.util.*;

public class PackageTest
{
	public static void main(String[] args)
	{
		while(Console.askYorN("Keep going?"))
		{
			System.out.println("D'oh!");
		}
		
		String str = "C:/javaclasses";
		
		boolean bool = Console.itemExists(str);
		
		if(bool) 
		{
			System.out.println("True");
		}
		else 
		{
			System.out.println("False");
		}
		
		
		System.out.println("Beginning Test for com.nicholasjacquet.util.StringTools");
		
		StringTools.markVowels();
		
		StringTools.countWords();
		
		
		/*
		  
		 
		{
			
		}
		
		*/
		
	}
}