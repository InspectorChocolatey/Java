package com.nicholasjacquet.util;

import java.util.Scanner;

public class StringTools
{
	static Scanner sc = new Scanner(System.in);
	
	public static void markVowels() 
	{
		System.out.println("Enter a string: ");
		// get string input from the user:
		String s = sc.nextLine();
		String originalString = s;
		
		int vowelCount = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if(    (c == 'A') || (c == 'a') 
			    || (c == 'E') || (c == 'e') 		
				|| (c == 'I') || (c == 'i')	
				|| (c == 'O') || (c == 'o')
				|| (c == 'U') || (c == 'u') )
			{
				String front = s.substring(0, i);
				String back = s.substring(0, i+1);
				s = front + "*" + back;
			}
		}

		System.out.println(s);
	}
	
	
	public static void countWords() 
	{
		System.out.println("Enter a string: ");
		// get string input from the user:
		String s = sc.nextLine();
		
		String[] word = s.split("\\s+");
		
		for(String w: word)
		{
			System.out.println(w);
		}
	}
	
	
}



