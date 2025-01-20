package adam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadStream
{
    private ReadStream() {}

    public static List<String> read()
    {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String line;
            do
            {
                line = br.readLine();
                lines.add(line);
            }
            while (!line.isEmpty());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> newRead()
    {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try
        {
            while((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }

        return lines;
    }
}
