import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * A superclass that holds all the file information for testing the loggers
 */
public class TestLogger
{
    public static String[] testPaths = {"/logs/", "/logsA/", "logsB/", "/logsC", "logsD"};
    public static String[] validationPaths = {"/logs/", "/logsA/", "/logsB/", "/logsC/", "/logsD/"};

    @BeforeEach
    void setUp()
    {
        for(String path: testPaths)
        {
            File testDir = getFile(path, "");
            if (!testDir.exists() || !testDir.isDirectory())
                testDir.mkdir();
        }
    }

    @AfterEach
    void tearDown()
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

    public File getFile(String testPath, String name)
    {
        FileSystem fileSystem = FileSystems.getDefault();
        String path = fileSystem.getPath("").toAbsolutePath().toString();
        path = path.concat(testPath + name);
        return new File(path);
    }
}
