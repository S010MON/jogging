
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

    @Test void testDefaultLogToTxt()
    {
        String exp = "Hello, darkness, my old friend";
        String act = "";

        Logger logger = new Logger();
        logger.log(exp);
        try {
            File defaultFile = getFile("log.txt");
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
            File defaultFile = getFile("log.txt");
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

        Logger logger = new Logger("log");
        for (String s : exp)
        {
            logger.log(s);
        }
        try {
            File defaultFile = getFile("log.txt");
            BufferedReader reader = new BufferedReader(new FileReader(defaultFile));
            for(int i = 0; i < exp.length; i++)
            {
                act[i] = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Unable to read default log.txt file");
            e.printStackTrace();
        }

        for(int i = 0; i < exp.length; i++)
        {
            assertEquals(exp[i], act[i]);
        }
    }

    private File getFile(String name)
    {
        FileSystem fileSystem = FileSystems.getDefault();
        String path = fileSystem.getPath("").toAbsolutePath().toString();
        path = path.concat(testPath + name);
        return new File(path);
    }
}
