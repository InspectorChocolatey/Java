package com.nicholasjacquet.util;

import java.util.Scanner;

/* The Console class contains:
* 
*   public static boolean askYorN(String prompt)
*   
* */

public class Console
{
	//String input;
	private String inputStr;
	
	static Scanner sc = new Scanner(System.in);
		
	public static boolean askYorN(String prompt)
	{
		while(true) 
		{
			String answer;
			System.out.print("\n" + prompt + " (Y or N) ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("Y")) {return true;}
			else if(answer.equalsIgnoreCase("N")) {return false;}
		}
	}
		
	public static boolean itemExists(String item)
	{
		java.io.File f = new java.io.File(item);
		if(f.exists()){return true;}
		else {return false;}
	}
	

	public void setInputStr(String inStr) 
	{
		this.inputStr = inStr;
	}

	/*
	public static String computername
	{
		
	}
	*/
}