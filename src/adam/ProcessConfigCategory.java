package adam;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProcessConfigCategory
{
    public static final String ASSIGNMENT_FILE_LOADING = "assignment file loading";
    public static final String ASSIGNMENT_ITEM_PROCESSING = "assignment item processing";
    public static final String COMMENT = "comment";
    public static final String EXIT_MESSAGE = "exit message";
    public static final String IGNORE_INCOMPLETE_ASSIGNMENTS = "ignore incomplete assignments";
    public static final String NOW = "now";
    public static final String OUTPUT_TYPE = "output type";
    public static final String SHOW_COMMENT = "show comments";
    public static final String SHOW_CONFIG_STATUS = "show config status";
    public static final String WELCOME_MESSAGE = "welcome message";
    private ProcessConfigCategory() {} // Utility class: do not instantiate

    private static Truthy toTruthy(String data)
    {
        switch (data.toLowerCase())
        {
            case "display":
                return Truthy.DISPLAY;
            case "on":
                return Truthy.ON;
            case "show":
                return Truthy.SHOW;
            case "true":
                return Truthy.TRUE;
            case "yes":
                return Truthy.YES;
            default:
                return Truthy.FALSE;
        }
    }

    public static Truthy toTruthy(boolean value)
    {
        if(value)
        {
            return Truthy.TRUE;
        }
        else
        {
            return Truthy.FALSE;
        }
    }

    private static OutputType toOutputType(String data)
    {
        switch (data.toLowerCase())
        {
            case "summary":
                return OutputType.SUMMARY;
            case "daily":
                return OutputType.DAILY;
            default:
                return null;
        }
    }

    public static Configuration processCategories(List<SplitInput> splitLines)
    {
        Truthy fileLoading = null;
        Truthy itemProcessing = null;
        List<String> comment = new ArrayList<>();
        Truthy exitMessage = null;
        Truthy ignoreIncomplete = null;
        String now = null;
        OutputType outputType = null;
        List<Truthy> showComment = new ArrayList<>();
        Truthy showConfigStatus = null;
        Truthy welcomeMessage = null;
        for ( SplitInput splitLine: splitLines)
        {
            String category = splitLine.category();
            String data = splitLine.data();

            switch (category)
            {
                case ASSIGNMENT_FILE_LOADING :
                    fileLoading = toTruthy(data);
                    Printer.SetConfig("ASSIGNMENT_FILE_LOADING",fileLoading);
                    break;
                case ASSIGNMENT_ITEM_PROCESSING:
                    itemProcessing = toTruthy(data);
                    Printer.SetConfig("ASSIGNMENT_ITEM_PROCESSING",itemProcessing);
                    break;
                case COMMENT:
                    comment.add(data);
                    break;
                case EXIT_MESSAGE:
                    exitMessage = toTruthy(data);
                    Printer.SetConfig("EXIT_MESSAGE",exitMessage);
                    break;
                case IGNORE_INCOMPLETE_ASSIGNMENTS:
                    ignoreIncomplete  = toTruthy(data);
                    Printer.SetConfig("IGNORE_INCOMPLETE_ASSIGNMENTS",ignoreIncomplete);
                    break;
                case NOW:
                    now = data;
                    Printer.SetConfig("NOW",now);
                    break;
                case OUTPUT_TYPE:
                    outputType = toOutputType(data);
                    Printer.SetConfig("OUTPUT_TYPE", outputType);
                    break;
                case SHOW_COMMENT:
                    showComment.add(toTruthy(data));
                    Printer.SetConfig("COMMENTS",showComment.get(showComment.size()-1));
                    break;
                case SHOW_CONFIG_STATUS:
                    showConfigStatus = toTruthy(data);
                    Printer.SetConfig("CONFIG_STATUS",showConfigStatus);
                    break;
                case WELCOME_MESSAGE:
                    welcomeMessage = toTruthy(data);
                    Printer.SetConfig("WELCOME_MESSAGE",welcomeMessage);
                    break;
                default:
                    System.out.printf(Messages.INVALID_APP_CONFIG_ITEM +"\n",category.toUpperCase());
                    //System.out.printf(Messages.VALID_POSSIBILITIES.toString(),"[ASSIGNMENT FILE LOADING, ASSIGNMENT ITEM PROCESSING, COMMENT, EXIT MESSAGE, IGNORE INCOMPLETE ASSIGNMENTS, NOW, OUTPUT TYPE, SHOW COMMENTS, SHOW CONFIG STATUS, WELCOME MESSAGE]");
            }
        }

        if(now == null)
        {
            now = ApplicationConfigurationConstants.DEFAULT_NOW.toString();
        }
//        else
//        {
//            Printer.SetConfig("NOW",now);
//        }

        if(showComment.isEmpty())
        {
            showComment.add(toTruthy(ApplicationConfigurationConstants.DEFAULT_SHOW_COMMENTS));
        }
//        else
//        {
//            Printer.SetConfig("COMMENTS",showComment.get(showComment.size()-1));
//        }

        if(welcomeMessage == null)
        {
            welcomeMessage = toTruthy(ApplicationConfigurationConstants.DEFAULT_SHOW_WELCOME_MESSAGE);
        }
//        else
//        {
//            Printer.SetConfig("WELCOME_MESSAGE",welcomeMessage);
//        }

        if(exitMessage == null)
        {
            exitMessage = toTruthy(ApplicationConfigurationConstants.DEFAULT_SHOW_EXIT_MESSAGE);
        }
//        else
//        {
//            Printer.SetConfig("EXIT_MESSAGE",exitMessage);
//        }

        if(showConfigStatus == null)
        {
            showConfigStatus = toTruthy(ApplicationConfigurationConstants.DEFAULT_SHOW_CONFIG_STATUS);
        }
//        else
//        {
//            Printer.SetConfig("CONFIG_STATUS",showConfigStatus);
//        }

        if(fileLoading == null)
        {
            fileLoading = toTruthy(ApplicationConfigurationConstants.DEFAULT_ASSIGNMENT_FILE_LOADING);
        }
//        else
//        {
//            Printer.SetConfig("ASSIGNMENT_FILE_LOADING",fileLoading);
//        }

        if(itemProcessing == null)
        {
            itemProcessing = toTruthy(ApplicationConfigurationConstants.DEFAULT_ASSIGNMENT_ITEM_PROCESSING);
        }
//        else
//        {
//            Printer.SetConfig("ASSIGNMENT_ITEM_PROCESSING",itemProcessing);
//        }

        if(ignoreIncomplete == null)
        {
            ignoreIncomplete = toTruthy(ApplicationConfigurationConstants.DEFAULT_IGNORE_INCOMPLETE_ASSIGNMENTS);
        }
//        else
//        {
//            Printer.SetConfig("IGNORE_INCOMPLETE_ASSIGNMENTS",ignoreIncomplete);
//        }

        if(outputType == null)
        {
            outputType = toOutputType(ApplicationConfigurationConstants.DEFAULT_OUTPUT_TYPE);
        }
//        else
//        {
//            Printer.SetConfig("OUTPUT_TYPE", outputType);
//        }

        return new Configuration(   fileLoading, itemProcessing, comment, exitMessage, ignoreIncomplete, now, outputType,
                showComment, showConfigStatus, welcomeMessage   );
    }





}
