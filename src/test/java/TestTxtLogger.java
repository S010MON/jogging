
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

    private File getFile(String name)
    {
        FileSystem fileSystem = FileSystems.getDefault();
        String path = fileSystem.getPath("").toAbsolutePath().toString();
        path = path.concat(testPath + name);
        return new File(path);
    }
}
