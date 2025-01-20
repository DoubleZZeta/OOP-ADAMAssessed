package adam;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class Printer
{
    private Printer() {} //Utility

    public static void PrintFileLoading (Configuration config, String fileName)
    {
        if(config.getFileLoading() != Truthy.FALSE)
        {
            System.out.printf(Messages.LOADING_ASSIGNMENT.toString(),fileName);
            System.out.println();
        }
    }

    public static void PrintItemProcessing (Configuration config, int linNumber, String category, String data, String fileName)
    {
        if(config.getItemProcessing() != Truthy.FALSE)
        {
            String content = String.format("ConfigurationItem[filename=%s, command=%s, data=%s, lineNumber=%d]",fileName,category.toUpperCase(),data,linNumber);
            System.out.printf(Messages.READ_CONFIGURATION_ITEM.toString(),content);
            System.out.println();
        }
    }

    public static void PrintExitMessage (Configuration config)
    {
        if(config.getExitMessage() != Truthy.FALSE)
        {
            System.out.print(Messages.EXIT+"\n");
        }
    }

    public static void PrintAssignmentComment (Configuration config, List<Assignment> assignments)
    {
        if(config.getShowComment().get(config.getShowComment().size()-1) != Truthy.FALSE)
        {
            for (Assignment assignment: assignments)
            {
                if(assignment.getComplete() && assignment.getComment() != null)
                {
                    System.out.printf(Messages.APPLICATION_COMMENT.toString(),assignment.getComment());
                    System.out.println();
                }

            }

        }
    }

    public static void PrintConfigurationComment (Configuration config)
    {
        for (int i = 0; i < config.getComments().size(); i++)
        {
            if(config.getShowComment().get(i) != Truthy.FALSE)
            {
                System.out.println(config.getComments().get(i));
            }
        }
    }

    public static void SetConfig(String command, Truthy value)
    {
        if(value != null)
        {
            System.out.printf(Messages.SETTING_APP_CONFIG_ITEM.toString(), command, value);
            System.out.println();
        }
    }
    public static void SetConfig(String command, OutputType value)
    {
        if(value != null)
        {
            System.out.printf(Messages.SETTING_APP_CONFIG_ITEM.toString(), command, value);
            System.out.println();
        }
    }

    public static void SetConfig(String command, String value)
    {
        if(value != null)
        {
            System.out.printf(Messages.SETTING_APP_CONFIG_ITEM.toString(), command, value);
            System.out.println();
        }
    }

//    public static void PrintSetConfig(Configuration config)
//    {
//        SetConfig("NOW",config.getNow());
//        SetConfig("SHOW COMMENTS",config.getShowComment().get(config.getShowComment().size()-1));
//        SetConfig("WELCOME MESSAGE",config.getWelcomeMessage());
//        SetConfig("EXIT MESSAGE",config.getExitMessage());
//        SetConfig("CONFIG STATUS",config.getShowConfig());
//        SetConfig("ASSIGNMENT_FILE_LOADING",config.getFileLoading());
//        SetConfig("ASSIGNMENT_ITEM_PROCESSING",config.getItemProcessing());
//        SetConfig("IGNORE_INCOMPLETE_ASSIGNMENTS",config.getIgnoreIncomplete());
//        SetConfig("OUTPUT TYPE", config.getOutputType());
//    }

    public static void ConfigStatus (Truthy command, String message, boolean defaultValue)
    {
        String content;
        if(command != null)
        {
            content = command.toString();
        }
        else
        {
            if(defaultValue)
            {
                content = ApplicationConfigurationConstants.SHOWING;
            }
            else
            {
                content = ApplicationConfigurationConstants.NOT_SHOWING;
            }
        }
        System.out.println(message+content);
    }

    public static void ConfigStatus (List<String> comment, String message)
    {
        String content;
        if(comment != null)
        {
            content = ApplicationConfigurationConstants.SHOWING;
        }
        else
        {
            content = ApplicationConfigurationConstants.NOT_SHOWING;
        }
        System.out.println(message+content);
    }

    public static void ConfigStatus(String now, String message, ZonedDateTime defaultValue)
    {
        String content;
        if(now != null)
        {
            content = now;
        }
        else
        {
            content = defaultValue.toString();
        }
        System.out.println(message+content);
    }

    public static void ConfigStatus(OutputType outputType, String message, String defaultValue)
    {
        String content;
        if(outputType != null)
        {
            content = outputType.toString();
        }
        else
        {
            content = defaultValue;
        }
        System.out.println(message+content);
    }


    public static void PrintConfigStatus(Configuration config)
    {
        if(config.getShowConfig() != Truthy.FALSE)
        {
            System.out.println("Application settings");
            ConfigStatus(config.getFileLoading(),"ASSIGNMENT_FILE_LOADING: ",ApplicationConfigurationConstants.DEFAULT_ASSIGNMENT_FILE_LOADING);
            ConfigStatus(config.getItemProcessing(),"ASSIGNMENT_ITEM_PROCESSING: ",ApplicationConfigurationConstants.DEFAULT_ASSIGNMENT_ITEM_PROCESSING);
            ConfigStatus(config.getComments(),"COMMENT: ");
            ConfigStatus(config.getExitMessage(),"EXIT_MESSAGE: ", ApplicationConfigurationConstants.DEFAULT_SHOW_EXIT_MESSAGE);
            ConfigStatus(config.getIgnoreIncomplete(),"IGNORE_INCOMPLETE_ASSIGNMENTS: ",ApplicationConfigurationConstants.DEFAULT_IGNORE_INCOMPLETE_ASSIGNMENTS);
            ConfigStatus(config.getNow(),"NOW: ",ApplicationConfigurationConstants.DEFAULT_NOW);
            ConfigStatus(config.getOutputType(),"OUTPUT_TYPE: ",ApplicationConfigurationConstants.DEFAULT_OUTPUT_TYPE);
            ConfigStatus(config.getShowComment().get(config.getShowComment().size()-1),"SHOW_COMMENTS: ",ApplicationConfigurationConstants.DEFAULT_SHOW_COMMENTS);
            ConfigStatus(config.getShowConfig(),"SHOW_CONFIG_STATUS: ",ApplicationConfigurationConstants.DEFAULT_SHOW_CONFIG_STATUS);
            ConfigStatus(config.getWelcomeMessage(),"WELCOME_MESSAGE: ",ApplicationConfigurationConstants.DEFAULT_SHOW_WELCOME_MESSAGE);
        }
    }



    public static void PrintWelcomeMessage (Configuration config)
    {
        if(config.getWelcomeMessage() != Truthy.FALSE)
        {
            System.out.println(Messages.WELCOME);
        }
    }

    public static void Summary(Assignment assignment)
    {
        System.out.println(assignment.toString(OutputType.SUMMARY));
    }

    public static void Daily(Assignment assignment)
    {
        System.out.println(assignment.toString(OutputType.DAILY));
    }

    public static void PrintSummary(List<Assignment> assignments, Configuration config)
    {
        PrintAssignmentComment(config,assignments);
        for (Assignment assignment: assignments)
        {
            if(assignment.getComplete())
            {
                Summary(assignment);
            }
        }
    }
    public static String Capitalize(String str)
    {
        str = str.toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static double Rounding(double value)
    {
        return (double)Math.round(value * 10d) / 10d;
    }

    public static void PrintDaily(List<Assignment> assignments, Configuration config)
    {
        PrintAssignmentComment(config,assignments);
        ZonedDateTime start = assignments.get(0).getStart();
        ZonedDateTime end = assignments.get(0).getEnd();
        for(Assignment assignment: assignments)
        {
            if(assignment.getStart().isBefore(start))
            {
                start = assignment.getStart();
            }

            if(assignment.getEnd().isAfter(end))
            {
                end = assignment.getEnd();
            }
        }
        int days = (int) Duration.between(start,end).toDays();

        for (int i = 0; i <= days; i++)
        {
            ZonedDateTime dayBetween = start.plusDays(i);
            double totalHours = 0;
            System.out.print(Capitalize(dayBetween.getDayOfWeek().toString())+", ");
            System.out.println(Capitalize(dayBetween.getMonth().toString())+" "+dayBetween.getDayOfMonth()+", "+dayBetween.getYear());
            for (Assignment assignment: assignments) //to print all the assignments to do in one day
            {
                if  (((dayBetween.isAfter(assignment.getStart()) && dayBetween.isBefore(assignment.getEnd()))
                        || dayBetween.equals(assignment.getEnd()) || dayBetween.equals(assignment.getStart()))
                        && (assignment.getComplete()))
                {
                    Daily(assignment);
                    totalHours += Rounding(assignment.getHoursPerDay());
                }
            }
            System.out.println(Messages.TOTAL_TOP_LINE);
            System.out.printf(Messages.DAILY_TOTAL+"\n", totalHours);
            System.out.println(Messages.TOTAL_BOTTOM_LINE);
        }
    }









}
