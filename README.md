![workflow](https://github.com/S010MON/jogging/actions/workflows/linux.yml/badge.svg)
![workflow](https://github.com/S010MON/jogging/actions/workflows/windows.yml/badge.svg)
![workflow](https://github.com/S010MON/jogging/actions/workflows/mac.yml/badge.svg)

--------------------------------------------------------------------------------------

# Jogging - Simple Logging Framework for Java

A simple framework for logging to file in java without too much setup. Intended for students and small projects where you want to get text logging up and running without worrying about imports, setup files, or trawling through documentation.  To use the framework, import all the source files directly into your project, everything runs on inbuilt libraries and logging can be done with two lines of code.  All information required to use the framework is described within this file.

## Contents
- ![Txt Logging](https://github.com/S010MON/jogging#text-logging)
    - ![Default](https://github.com/S010MON/jogging#default)
    - ![Specified File Name](https://github.com/S010MON/jogging#specified-name)
    - ![Specified File Location](https://github.com/S010MON/jogging#specified-name-and-location)
- ![Csv Logging](https://github.com/S010MON/jogging#csv-logging)
    - ![String Arrays](https://github.com/S010MON/jogging#string-arrays)
    - ![Integer Arrays](https://github.com/S010MON/jogging#integer-arrays)
    - ![Double Arrays](https://github.com/S010MON/jogging#double-arrays)
- ![Licence](https://github.com/S010MON/jogging#license)

## Text Logging
There are three types of .txt logging:

### Default
To create a default logger, build a new instance of the Logger class.
This will create a default `logs` folder in your project root and save as `/logs/log.txt`
    
```java
Logger logger = new Logger();
logger.log("Hello, darkness, my old friend");
```

### Specified File name
If you want to specify a name to save your logs as, pass the `fileName` parameter at the creation of the logger.  
Note that there is no need to pass a file extention to the name. 

```java
Logger logger = new Logger("myLogName");
logger.log("I've come to talk with you again");
``` 

### Specified name and location
If you want to specify a location to save your logs, pass the `internalFilePath` parameter at the creation of the logger.  

```java
Logger logger = new Logger("/my/log/location/here/", "myLogName");
logger.log("Because a vision softly creeping");
```

## CSV Logging
There exists a utility to log to CSV format before using the `log()` method.  Simply set the CSV parameter to true to change the output file extention.  Each line will be appended with a comma delimiter so that the code below creates the line _Left,its,seeds,while,I,was,sleeping,_ in the log file. 

```java
Logger logger = new Logger();                                   // Create a new logger
logger.setToCSV();                                              // Set the CSV to true
logger.log("Left,its,seeds,while,I,was,sleeping");              // Log a user formatted comma seperated string to a .csv file
logger.setToTxt();                                              // Set the CSV to false (logging will now go to a .txt file of the same name)
```

### String Arrays
By passing an array of Strings or integers to the `log()` method which will format the strings with delimiters automatically

```java
String[] myStringArray = {"And","the","vision","that","was","planted","in","my","brain"};
logger.log(myStringArray);
```

### Integer Arrays

```java
int[] myIntegerArray = {1,2,3,4,5,6,7,8,9};
logger.log(myIntegerArray);
```

### Double Arrays

```java
double[] myDoubleArray = {1.1,2.2,3.3,4.4,5.5};
logger.log(myDoubleArray);
```
</br>

----

</br>

## License
Copyright (c) 2021 Leon Debnath

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
