package corba.startprocess;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Nicholas
 *
 * References:
 *
 * <pidly stuff>
 *		https://stackoverflow.com/questions/21068440/eclipse-wont-compile-run-java-file
 *
 *
 * <cool stuff>
 *     <Execute an external program Tag(s): IO>
 *		5*'s http://www.rgagnon.com/javadetails/java-0014.html
 *		
 *		http://pages.cs.wisc.edu/~hasti/cs368/JavaTutorial/NOTES/JavaIO_Scanner.html
 *
 *
 *
 *
 * <invoke string expressions as dos language>
 * 
 * 	help wmic
 * 
 * 
 * 
 * <invoke string expressions as powershell lang>
 *
 *	
 *
 *
 * <this would be a banging thing to do with RMI (~even without powershell yet)>
 *
 *
 *
 *
 *
 *
 *
 * c:\WINDOWS\system32\WindowsPowerShell\v1.0\powershell.exe -command 'C:\tools\cygwin\home\Nicholas\Desktop\ps1\Invoke-Beep.ps1'
 *
 * Error: <the method getAbsolutePath() is undefined for the type String>
 * https://www.tutorialspoint.com/java/io/file_getabsolutefile.htm
 *
 *
 * 		// so maybe powershell isnt a valid win32 application so what... (-;
 * 		String obj = "c:/WINDOWS/system32/WindowsPowerShell/v1.0/powershell.exe -command " + command;
 *
 *		      // examples:
 *		      //Process p = Runtime.getRuntime().exec("cmd /c dir");
 *		      //Process p = Runtime.getRuntime().exec("cmd /c notepad");
 *
 **/

public class Exec {

	public static void main(String args[]) {
		startByFileExtension("C:/tools/cygwin/home/Nicholas/Desktop/GBCPUman.pdf");
		while (true) {
			invokeCommand(getCommand());
		}
	}

	public static void invokeCommand(String command) {
		String obj = "cmd /c " + command;
		try {
			String line;
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader bri = new BufferedReader
					(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader
					(new InputStreamReader(p.getErrorStream()));
			while ((line = bri.readLine()) != null) {
				System.out.println(line);
			}
			bri.close();
			while ((line = bre.readLine()) != null) {
				System.out.println(line);
			}
			bre.close();
			p.waitFor();
			System.out.println("				");
		}
		catch (Exception err) {
			err.printStackTrace();
		}
	}


	public static String getCurrentDirectory() {
		return System.getProperty("user.dir");
	}

	public static String getCommand() {
		Scanner scanner = new Scanner( System.in );
		System.out.print( getCurrentDirectory() + ">" );
		String command = scanner.nextLine();
		return command;
	}

	// "file" is the filename of the data file
	//  ex. myresume.doc
	//  to start Word if the doc extension is associated with it.
	public static void startByFileExtension(String path) {
		File file = new File(path);
		try {
			Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
