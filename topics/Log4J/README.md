/*
Topic: Debugging Java with Log4J
Url:   
*/

Debug any application
=======================================================

1) Log4J

*Can write data to the console.
*Can write data to a file.
*Can work on multiple files.
*Addresses file size increase issues while maintaining latest log contents,
*Have a maximum restriction on the number of files that can be created(rolled)


   Logging Levels

    -TRACE
    -DEBUG
    -INFO
    -WARN
    -ERROR
    -FATAL


Considerations when Implementing Log4J

  1.) There should be a configuration which supports things mentioned above
      
       -XML file configuration / property file configuration
       -log4j.xml
