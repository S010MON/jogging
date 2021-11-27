import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    private String filePath;

    /**
     * Default constructor path set to projectRoot/log/
     */
    public Logger()
    {
        this.filePath = FilePath.getInternal("/logs/");
        File dir = new File(filePath);
        createDirectory(dir);
    }

    /**
     * Set different logging location using the internal filePath from the project root
     * @param internalFilePath - "/src/main/java/src/config/"
     */
    public Logger(String internalFilePath)
    {
        this.filePath = FilePath.getInternal(internalFilePath);
        File dir = new File(filePath);
        createDirectory(dir);
    }

    public void createDirectory(File file)
    {
        if(!file.exists() || !file.isDirectory())
        {
            boolean success = file.mkdirs();
            if (!success)
                throw new RuntimeException("Logging directory was not created");
        }
    }

    /**
     * Append a string to a new line of a {@code .txt} file
     * Creates a new file if one cannot be found
     * @param fileName  - The name of the file
     * @param str		- The string to append
     */
    public void log(String fileName, String str)
    {
        try
        {
            fileName = fileName.concat(".txt");
            String filePath = this.filePath + fileName;
            File file = new File(filePath);

            if(!file.exists())
            {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.append("\n");
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found");
            System.out.println("File path used: " + this.filePath + fileName);
            e.printStackTrace();
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
            String fileName = "log.txt";
            String filePath = this.filePath + fileName;
            File file = new File(filePath);

            if(!file.exists())
            {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.append("\n");
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found");
            System.out.println("File path used: " + this.filePath + "log.txt");
            e.printStackTrace();
        }
    }

    /**
     * Append a string to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param fileName  - The name of the file
     * @param str		- The comma delimited string to append
     */
    public void logCSV(String fileName, String str)
    {
        try
        {
            fileName = fileName.concat(".csv");
            String filePath = this.filePath + fileName;
            File file = new File(filePath);

            if(!file.exists())
            {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.append("\n");
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found");
            System.out.println("File path used: " + this.filePath + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Append a string to a new line of a {@code .csv} file
     * Creates a new file if one cannot be found
     * @param fileName  - The name of the file
     * @param str		- The array of strings to append with comma delimiters
     */
    public void logCSV(String fileName, String[] str)
    {
        try
        {
            fileName = fileName.concat(".csv");
            String filePath = this.filePath + fileName;
            File file = new File(filePath);

            if(!file.exists())
            {
                boolean success = file.createNewFile();
                if (!success)
                    throw new RuntimeException("File: " + fileName + " was not created");
            }

            FileWriter writer = new FileWriter(file, true);
            for (String s : str)
            {
                writer.write(s + ",");
            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found");
            System.out.println("File path used: " + this.filePath + fileName);
            e.printStackTrace();
        }
    }
}