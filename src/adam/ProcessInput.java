package adam;

import java.util.ArrayList;
import java.util.List;

public class ProcessInput
{
    private ProcessInput() {} // Makes this a utility class

    public static List<SplitInput> splitInput(List<String> fileLines)
    {
        List<SplitInput> splitLines = new ArrayList<>(fileLines.size()*2);
        for (String fileLine : fileLines)
        {
            String[] components = fileLine.split("\t",2);
            if (!(components.length < 2 || fileLine.isBlank()))
            {
                String category = normaliseCategory(components[0]);
                String data = normaliseData(components[1]);
                splitLines.add(new SplitInput(category,data));
            }
        }
        return splitLines;
    }

    public static String normaliseData(String rawData)
    {
        return rawData.trim();
    }
    public static String normaliseCategory(String rawCategory)
    {
        rawCategory = rawCategory.trim();
        StringBuilder newCategory = new StringBuilder();
        for (int i = 0; i < rawCategory.length(); i++)
        {
            if(Character.isAlphabetic(rawCategory.charAt(i)))
            {
                newCategory.append(rawCategory.toLowerCase().charAt(i));
            }
            else
            {
                newCategory.append(" ");
            }
        }
        return newCategory.toString();
    }
}
