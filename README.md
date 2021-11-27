![workflow](https://github.com/S010MON/jogging/actions/workflows/linux.yml/badge.svg)
![workflow](https://github.com/S010MON/jogging/actions/workflows/windows.yml/badge.svg)
![workflow](https://github.com/S010MON/jogging/actions/workflows/mac.yml/badge.svg)

--------------------------------------------------------------------------------------

# Jogging - Simple Logging Framework for Java

A simple framework for logging to file in java without too much setup. Intended for students and small projects where you want to get text logging up and running without worrying about imports, setup files, or trawling through documentation.  To use the framework, import all the source files directly into your project, everything runs on inbuilt libraries and logging can be done with two lines of code.  All information required to use the framework is described within this file.

### Text Logging
There are three types of .txt logging:

#### Default
To create a default logger, build a new instance of the Logger class.
This will create a default `logs` folder in your project root and save as `/logs/log.txt`

    Logger logger = new Logger();
    logger.log("Hello, darkness, my old friend");

#### Specified name
If you want to specify a name to save your logs as, pass the `fileName` parameter at the creation of the logger.  
Note that there is no need to pass a file extention to the name. 

    Logger logger = new Logger("myLogName");
    logger.log("I've come to talk with you again");
    
#### Specified name and location
If you want to specify a location to save your logs, pass the `internalFilePath` parameter at the creation of the logger.  
Note that the `internalFilePath` **must** start and end with `/` or you will recieve an error.

    Logger logger = new Logger("/my/log/location/here/", "myLogName");
    logger.log("Because a vision softly creeping");

### CSV Logging
There exists a utility to log to CSV format instead using the `log()` method.  Simply set the CSV parameter to true to change the output file extention.  Each line will be appended with a comma delimiter so that the code below creates the line _Left,its,seeds,while,I,was,sleeping,_ in the log file. 

    Logger logger = new Logger();                                   // Create a new logger
    logger.setToCSV();                                              // Set the CSV to true
    logger.log("Left,its,seeds,while,I,was,sleeping");              // Log a user formatted comma seperated string to a .csv file
    logger.setToTxt();                                              // Set the CSV to false (logging will now go to a .txt file of the same name)
    
 Or by passing an array of Strings or integers to the `log()` method which will format the strings with delimiters automatically:
 
    String[] myStringArray = {"And","the","vision","that","was","planted","in","my","brain"};
    logger.log(myStringArray);
    
    int[] myIntegerArray = {1,2,3,4,5,6,7,8,9};
    logger.log(myIntegerArray);

    double[] myDoubleArray = {1.1,2.2,3.3,4.4,5.5};
    logger.log(myDoubleArray);
    
