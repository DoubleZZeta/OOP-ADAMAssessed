package adam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile
{
    private ReadFile() {} // Make the default constructor private
    public static List<String> read(String filename)
    {
        List<String> lines;
        try
        {
            lines = Files.readAllLines(Paths.get(filename));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static String getFile(String filename)
    {
        String lines;
        try
        {
            lines = Files.readAllLines(Paths.get(filename)).toString();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return lines;
    }

}
