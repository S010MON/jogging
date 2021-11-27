# SLF4J - Simple Logging Framework for Java

A simple framework for logging to file in java without too much setup.  To use the framework, import the files directly into your project.

### Text Logging
To create a logger, build a new instance of the Logger class:

    Logger logger = new Logger();
    logger.log("My text to be appended to the log file");
 
This will create a default `log` folder in your project root and save as a .txt.  If you want to specify a location to save your logs, pass the `internalFilePath` parameter at the creation of the logger.  Note that the internalFilePath must start and end with '/' or you will recieve an error.

    Logger logger = new Logger("/my/log/location/here/");
    logger.log("My text to be appended to the log file");

### CSV Logging
There exists a utility to log to CSV format instead using the `logCSV()` method.  This can either be done by passing a delimited string to the method like so:

    String fileName = "log";
    String myCSV = "this,text,is,already,delimited";
    logger.logCSV(fileName, myCSV);
    
 Or by passing an array of Strings to the CSV method which will format the strings with delimiters automatically
 
    String fileName = "log";
    String[] myStringArray = {"this","text","is","not","delimited"};
    logger.logCSV(fileName, myStringArray);
    
