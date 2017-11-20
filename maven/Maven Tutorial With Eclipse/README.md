cd "$HOME\Desktop"
git clone https://github.com/in28minutes/MavenIn28Minutes MavenIn28Minutes

The goal of this project is to output a spring.jar that contains
the functionality from App & AppTest so that I can give that jar
file to a friend who is a developer and who wants to use them as
a dependency.

[ ] Goal: Create a spring.jar 
 
    Steps:

[ ] 1.) App.java -> App.class
[ ] 2.) AppTest.java -> AppTest.class
[ ] 3.) Run the unit test
[ ] 4.) Combile all class files into a jar.

#=Notes==========================================

Maven values convention over configuration

  defaults:
  1) src/main/java    /App.java
  2) src/test/java    /AppTest.java
  3) pom.xml (Project Object Model)

#=Commands=======================================
mvn --version #show the maven/version info 

mvn compile #creates $APP_HOME/target/classes
             #       $APP_HOME/target/maven-status      

mvn test-compile # creates $APP_HOME/target/test-classes

mvn -e #view stack trace


mvn clean #deletes $APP_HOME/target 

mvn test # runs the junit tests

mvn help:effective-pom

#=Maven_Build_Phases=============================

*The build-lifecycle in maven is as follows:

Compile source files
Compile test files
Run junit test
Package and create the jars
Install it/deploy it

*note that the mvn install command does all 5 steps of the maven build lifecycle


#=pom.xml=======================================

@27:00

In a maven project, a pom.xml file in a xml file that
defines:

the name of the project, 
the current project version,
the type of packaging, [.jar,.war,.ear] *revisit this in the video*
the project dependencies,
the project plugins *revist this in the video*


<groupId>com.in28minutes.maven</groupID> # <--- can be thought of just like a java package  
<artifactId>basic-maven-example</artifactId>



#running the mvn web app
mvn tomcat7:run

#=Local_Maven_Repository========================



