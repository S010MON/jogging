import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    private String directoryPath;
    private String fileName;

    /**
     * Default constructor path set to projectRoot/log/
     */
    public Logger()
    {
        this.directoryPath = FilePath.getInternal("/logs/");
        this.fileName = "log";
        createDirectory();
    }

    /**
     * Set different logging location using the internal filePath from the project root
     * @param fileName - "log"
     */
    public Logger(String fileName)
    {
        this.directoryPath = FilePath.getInternal("/logs/");
        this.fileName = fileName;
        createDirectory();
    }

    /**
     * Set different logging location using the internal filePath from the project root
     * @param internalFilePath - "/src/main/java/src/config/"
     * @param fileName - "log"
     */
    public Logger(String internalFilePath, String fileName)
    {
        this.directoryPath = FilePath.getInternal(internalFilePath);
        this.fileName = fileName;
        createDirectory();
    }

    public void createDirectory()
    {
        File file = new File(directoryPath + fileName);
        if(!file.exists() || !file.isDirectory())
        {
            boolean success = file.mkdirs();
            if (!success)
                throw new RuntimeException("Logging directory was not created");
        }
    }

    /**
     * Append a string to a new line of the {@code log.txt} file
     * Creates a new file if one cannot be found
     * @param str		- The string to append
     */
    public void log(String str)
    {
        try
        {
            File file = getTxtFile();
            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("unable to log to csv" +
                    "\nPath: " + directoryPath +
                    "\nName: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Append a string to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param str		- The comma delimited string to append
     */
    public void logCSV(String str)
    {
        try {
            File file = getCsvFile();
            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.append("\n");
            writer.close();
            } catch (IOException e) {
            System.out.println("unable to log to csv" +
                    "\nPath: " + directoryPath +
                    "\nName: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Append a string to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param str		- The array of strings to append with comma delimiters
     */
    public void logCSV(String[] str)
    {
        try {
            File file = getCsvFile();
            FileWriter writer = new FileWriter(file, true);
            for (String s : str) {
                writer.write(s + ",");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("unable to log to csv" +
                    "\nPath: " + directoryPath +
                    "\nName: " + fileName);
            e.printStackTrace();
        }
    }

    private File getTxtFile()
    {
        String filePath = directoryPath + fileName + ".txt";
        return  getFile(filePath);
    }

    private File getCsvFile()
    {
        String filePath = directoryPath + fileName + ".csv";
        return  getFile(filePath);
    }

    private File getFile(String filePath)
    {
        File file = new File(filePath);
        try
        {
            if (!file.exists()) {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }

        }  catch(IOException e) {
            System.out.println("File not found");
            System.out.println("File path used: " + filePath);
            e.printStackTrace();
        }
        return file;
    }
}