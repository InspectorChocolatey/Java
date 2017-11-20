package com.nicholasjacquet.texttospeech;

//import jdk.nashorn.internal.ir.WhileNode;
import java.util.Scanner;

public class MyTest 
{
	static Voice voice = new Voice("kevin16");
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		while(true)
		{
			String input = sc.nextLine();
			System.out.println(input);
			voice.say(input);
		}
	}
}
