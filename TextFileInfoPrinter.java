import java.util.*;
import java.io.*;
/*
    References: 

    https://stackoverflow.com/questions/15239371/counting-number-of-lines-words-and-characters-in-a-text-file

*/


public class TextFileInfoPrinter
{  
    public static void main(String[]args) throws FileNotFoundException        
    { 
    	Scanner console = new Scanner(System.in);           

    	System.out.println("File to be read: ");
        String inputFile = console.next();

        File file = new File(inputFile);
        Scanner in = new Scanner(file);

        int words = 0;
        int lines = 0;
        int chars = 0;

            /*
            while(in.hasNext())
            {
                in.next();
                words++;
            }

            while(in.hasNextLine())
            {
                in.nextLine();
                lines++;
            }

            while(in.hasNextByte())
            {
                in.nextByte();
                chars++;
            }
            */

        while(in.hasNextLine())  
		{
			lines++;
        	String line = in.nextLine();
        	chars += line.length();
        	words += new StringTokenizer(line, " ,").countTokens();
    	}

    	System.out.println("Number of lines: " + lines);
    	System.out.println("Number of words: " + words);
		System.out.println("Number of characters: " + chars);
    }
}
