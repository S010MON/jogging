import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCsvLogger
{
    public static String testPath = "/logs/";

    @BeforeEach void setUp()
    {
        File testDir = getFile("");
        if (!testDir.exists() || !testDir.isDirectory())
            testDir.mkdir();
    }

    @AfterEach void tearDown()
    {
        File testDir = getFile("");
        if (testDir.exists())
        {
            String[] files = testDir.list();
            for(String s: files)
            {
                File currentFile = new File(testDir.getPath(), s);
                currentFile.delete();
            }
            testDir.delete();
        }
    }

    @Test void testDefaultLogString()
    {
        String exp = "Hello,darkness,my,old,friend,";
        String act = "";

        Logger logger = new Logger();
        logger.setToCSV();
        logger.log(exp);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
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
        logger.setToCSV();
        logger.log(input);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
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
        logger.setToCSV();
        logger.log(exp);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
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
        logger.setToCSV();
        logger.log(exp);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
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
        logger.setToCSV();
        logger.log(input);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
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
        logger.setToCSV();
        logger.log(input);
        try {
            File defaultFile = getFile("log.csv");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read default log.csv file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    private File getFile(String name)
    {
        FileSystem fileSystem = FileSystems.getDefault();
        String path = fileSystem.getPath("").toAbsolutePath().toString();
        path = path.concat(testPath + name);
        return new File(path);
    }
}
