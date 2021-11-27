![workflow](https://github.com/S010MON/simple-logging-framework/actions/workflows/linux.yml/badge.svg)

--------------------------------------------------------------------------------------

# SLF4J - Simple Logging Framework for Java

A simple framework for logging to file in java without too much setup.  To use the framework, import the files directly into your project.

### Text Logging
There are three types of .txt logging
- Default
- Specified name
- Specified location and name

##### Default
To create a default logger, build a new instance of the Logger class.
This will create a default `logs` folder in your project root and save as `/logs/log.txt`

    Logger logger = new Logger();
    logger.log("Hello, darkness, my old friend");

##### Specified name
If you want to specify a name to save your logs as, pass the `fileName` parameter at the creation of the logger.  
Note that there is no need to pass a file extention to the name. 

    Logger logger = new Logger("myLogName");
    logger.log("I've come to talk with you again");
    
##### Specified name and location
If you want to specify a location to save your logs, pass the `internalFilePath` parameter at the creation of the logger.  
Note that the `internalFilePath` *must* start and end with `/` or you will recieve an error.

    Logger logger = new Logger("/my/log/location/here/", "myLogName");
    logger.log("Because a vision softly creeping");

### CSV Logging
There exists a utility to log to CSV format instead using the `logCSV()` method.  This can either be done by passing a delimited string to the method like so:

    String fileName = "log";
    String myCSV = "this,text,is,already,delimited";
    logger.logCSV(fileName, myCSV);
    
 Or by passing an array of Strings to the CSV method which will format the strings with delimiters automatically
 
    String fileName = "log";
    String[] myStringArray = {"this","text","is","not","delimited"};
    logger.logCSV(fileName, myStringArray);
    
