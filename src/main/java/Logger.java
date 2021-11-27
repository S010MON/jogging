import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    private String directoryPath;
    private String fileName;
    private boolean CSV = false;
    private boolean append = true;

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
        try {
            FileWriter writer = getFileWriter();
            assert writer != null;
            writer.write(str + "\n");
            writer.close();
        } catch (IOException e) {
            printExceptionMessage();
            e.printStackTrace();
        }
    }

    /**
     * Append a string array to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param str		- The array of strings to append with comma delimiters
     */
    public void log(String[] str)
    {
        String delim = getDelimiter();
        try {
            FileWriter writer = getFileWriter();
            assert writer != null;
            for (String s : str)
            {
                writer.write(s + delim);
            }
            writer.close();
        } catch (IOException e) {
            printExceptionMessage();
            e.printStackTrace();
        }
    }

    /**
     * Append an integer array to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param I		- The array of integers to append with comma delimiters
     */
    public void log(int[] I)
    {
        String delim = getDelimiter();
        try {
            FileWriter writer = getFileWriter();
            for (int i : I)
            {
                writer.write(i + delim);
            }
            writer.close();
        } catch (IOException e) {
            printExceptionMessage();
            e.printStackTrace();
        }
    }

    /**
     * Append a double array to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param D		- The array of doubles to append with comma delimiters
     */
    public void log(double[] D)
    {
        String delim = getDelimiter();
        try {
            FileWriter writer = getFileWriter();
            for (double d : D)
            {
                writer.write(d + delim);
            }
            writer.close();
        } catch (IOException e) {
            printExceptionMessage();
            e.printStackTrace();
        }
    }

    public void setToCSV()
    {
        CSV = true;
    }

    public void setToTxt()
    {
        CSV = false;
    }

    public void setDirectoryPath(String directoryPath)
    {
        this.directoryPath = directoryPath;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    private FileWriter getFileWriter()
    {
        String filePath = directoryPath + fileName;
        if(CSV)
            filePath = filePath + ".csv";
        else
            filePath = filePath + ".txt";
        File file = new File(filePath);

        try {
            if (!file.exists())
            {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }
            return new FileWriter(file, append);
        }  catch(IOException e) {
            System.out.println("File not found");
            System.out.println("File path used: " + filePath);
            e.printStackTrace();
        }
        return null;
    }

    private void printExceptionMessage()
    {
        System.out.println("unable to log to csv" +
                "\nPath: " + directoryPath +
                "\nName: " + fileName);
    }

    private String getDelimiter()
    {
        if(CSV)
            return ",";
        return "";
    }
}