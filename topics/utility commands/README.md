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


# Make a manifest.txt file so that I can make a jar:
echo "main-class: Craps" > manifest.txt

# put a .class into a jar:
jar cfvm SayHello.jar Manifest.txt SayHello.class 

# execute a jar:
java -jar SayHello.jar

# see what is inside of a jar:
jar tf SayHello.jar

# add the txt directory (which is right along side my jar) + all of childitems of /txt into my jar:
jar uf SayHello.jar txt 

# extract all items inside a jar:
jar xf SayHello.jar
