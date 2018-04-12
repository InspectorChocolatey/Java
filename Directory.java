package crestomathy;

/*
 * @author NicholasJ
 *
 * references:
 *	
 *	https://stackoverflow.com/questions/3634853/how-to-create-a-directory-in-java
 *
 *  existsDirectory
 *	newDirectory
 *	removeDirectory
 *
 */

public class Directory 
{
	// works on only directories but creates any necessary parents
	public static void newDirectory(String directory)
	{
		new java.io.File(directory).mkdirs();
	}
	
	// works on both files and directories
	public static void removeDirectory(String directory) 
	{
		new java.io.File(directory).delete();
	}
	
	// works on both files and directories
	public static Boolean existsDirectory(String directory) 
	{
		return new java.io.File(directory).exists();
	} 
}
