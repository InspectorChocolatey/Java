# Create a .class file from a .java file:
javac C:\javaclasses\nicholasjacquet\util\Console.java

# Run a .class file:
java C:\javaclasses\nicholasjacquet\test\PackageTest

# Run a .class file while allocating upto 2 gigs of memory space to the java heap :
java -Xmx2048m C:\javaclasses\nicholasjacquet\test\PackageTest

# Create documentation pages in the current directory:
javadoc com\nicholasjacquet\payroll*.java

# Start a Java program from a jar file:
java -jar FractalExplorer.jar

# Display a member inventory from a .class Java file in command line:
javap C:\javaclasses\com\nicholasjacquet\util\Console.class
