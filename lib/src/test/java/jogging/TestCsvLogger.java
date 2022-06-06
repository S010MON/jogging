package jogging;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCsvLogger extends TestLogger
{
    @Test void testDefaultLogString()
    {
        String exp = "Hello,darkness,my,old,friend,";
        String act = "";

        Logger logger = new Logger();
        logger.setOutputCsv();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0], "log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testDefaultLogStringArray()
    {
        String[] input = {"Hello","darkness", "my","old","friend"};
        String exp = "Hello,darkness,my,old,friend,";
        String act = "";

        Logger logger = new Logger();
        logger.setOutputCsv();
        logger.log(input);
        try {
            File defaultFile = getFile(testPaths[0], "log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testSpecifiedNameLogString()
    {
        String exp = "I've,come,to,talk,with,you,again,";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0], "log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }
        assertEquals(exp, act);
    }

    @Test void testCsvfileEnding()
    {
        String exp = "I've,come,to,talk,with,you,again,";
        String act = "";

        Logger logger = new Logger("log.csv");
        logger.setOutputCsv();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0],"log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }
        assertEquals(exp, act);
    }

    @Test void testChangeCsvfileEnding()
    {
        String exp = "I've,come,to,talk,with,you,again,";
        String act = "";

        Logger logger = new Logger();
        logger.setFileName("log.csv");
        logger.setOutputCsv();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0],"log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }
        assertEquals(exp, act);
    }

    @Test void testSpecifiedNameLogStringArray()
    {
        String[] input = {"I've","come","to","talk","with","you","again"};
        String exp = "I've,come,to,talk,with,you,again,";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0],"log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testDefaultLogIntArray()
    {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        String exp = "1,2,3,4,5,6,7,8,9,10,";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.log(input);
        try {
            File defaultFile = getFile(testPaths[0],"log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testDefaultLogDoubleArray()
    {
        double[] input = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.01};
        String exp = "1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.01,";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.log(input);
        try {
            File defaultFile = getFile(testPaths[0],"log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testDelimeterChange()
    {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        String exp = "1!2!3!4!5!6!7!8!9!10!";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.setDelimiter("!");
        logger.log(input);
        try {
            File defaultFile = getFile(testPaths[0], "log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testNewLineAfterArray()
    {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        String exp = "1,2,3,4,5,6,7,8,9,10,\n1,2,3,4,5,6,7,8,9,10,";
        String act = "";

        Logger logger = new Logger("log");
        logger.setOutputCsv();
        logger.log(input);
        logger.log(input);
        try {
            File defaultFile = getFile(testPaths[0], "log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine() + "\n" + reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }
}
