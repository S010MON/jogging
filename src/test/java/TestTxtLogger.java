
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static org.junit.jupiter.api.Assertions.*;

public class TestTxtLogger
{
    public static String[] testPaths = {"/logs/", "/logsA/", "logsB/", "/logsC", "logsD"};
    public static String[] validationPaths = {"/logs/", "/logsA/", "/logsB/", "/logsC/", "/logsD/"};

    @BeforeEach void setUp()
    {
        for(String path: testPaths)
        {
            File testDir = getFile(path, "");
            if (!testDir.exists() || !testDir.isDirectory())
                testDir.mkdir();
        }
    }

    @AfterEach void tearDown()
    {
        for(String path: testPaths)
        {
            File testDir = getFile(path, "");
            if (testDir.exists()) {
                String[] files = testDir.list();
                for (String s : files) {
                    File currentFile = new File(testDir.getPath(), s);
                    currentFile.delete();
                }
                testDir.delete();
            }
        }
    }

    @Test void testDefaultLogToTxt()
    {
        String exp = "Hello, darkness, my old friend";
        String act = "";

        Logger logger = new Logger();
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0], "log.txt");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }

        assertEquals(exp, act);
    }

    @Test void testSpecifiedNameLogToTxt()
    {
        String exp = "I've come to talk with you again";
        String act = "";

        Logger logger = new Logger("log");
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0], "log.txt");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }
        assertEquals(exp, act);
    }

    @Test void testSpecifiedNameLogToTxtMulti()
    {
        String[] exp = {"Hello, darkness, my old friend",
                "I've come to talk with you again",
                "Because a vision softly creeping",
                "Left its seeds while I was sleeping",
                "And the vision that was planted in my brain",
                "Still remains",
                "Within the sound of silence",};
        String[] act = new String[7];

        Logger logger = new Logger("logfile");
        for (String s : exp) {
            logger.log(s);
        }
        try {
            File defaultFile = getFile(testPaths[0], "logfile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            for (int i = 0; i < exp.length; i++) {
                act[i] = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }

        for (int i = 0; i < exp.length; i++) {
            assertEquals(exp[i], act[i]);
        }
    }

    @Test void testSpecifiedPathLogToTxt()
    {
        for(int i = 0; i < testPaths.length; i++)
        {
            String exp = "Hello, darkness, my old friend";
            String act = "";

            Logger logger = new Logger(testPaths[i], "log");
            logger.log(exp);
            try {
                File defaultFile = getFile(validationPaths[i], "log.txt");
                BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
                act = reader.readLine();
            } catch (IOException e) {
                System.out.println("Unable to read default log.txt file");
                e.printStackTrace();
            }

            assertEquals(exp, act);
        }
    }

    @Test void testTxtFileEnding()
    {
        String exp = "I've come to talk with you again";
        String act = "";

        Logger logger = new Logger("log.txt");
        logger.log(exp);
        try {
            File defaultFile = getFile(testPaths[0], "log.txt");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            act = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }
        assertEquals(exp, act);
    }

    private File getFile(String testPath, String name)
    {
        FileSystem fileSystem = FileSystems.getDefault();
        String path = fileSystem.getPath("").toAbsolutePath().toString();
        path = path.concat(testPath + name);
        return new File(path);
    }
}
