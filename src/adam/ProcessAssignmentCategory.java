package adam;

import java.time.ZonedDateTime;
import java.util.List;

public class ProcessAssignmentCategory
{
    public static final String NAME = "name";
    public static final String HOURS = "hours";
    public static final String START = "start";
    public static final String END = "end";
    public static final String COURSE = "course";
    public static final String POINTS = "points";
    public static final String COMMENT    = "comment";

    private ProcessAssignmentCategory() {} // Utility class: do not instantiate

    public static Assignment processCategories(List<SplitInput> splitLines, Configuration config, String filename)
    {
        String name = null;
        double hours = 0;
        ZonedDateTime start = null;
        ZonedDateTime end = null;
        String course = null;
        double points = 0;
        String  comment = null;
        int line = 1;
        for ( SplitInput splitLine : splitLines )
        {
            String category = splitLine.category();
            String data = splitLine.data();
            switch (category)
            {
                case NAME:
                    name = data;
                    break;
                case HOURS:
                    hours = Double.parseDouble(data);
                    break;
                case START:
                    start = ZonedDateTime.parse(data);
                    break;
                case END:
                    end = ZonedDateTime.parse(data);
                    break;
                case COURSE:
                    course = data;
                    break;
                case POINTS:
                    points = Double.parseDouble(data);
                    break;
                case COMMENT:
                    comment = data;
                    break;
                default:
                    System.out.printf(Messages.UNKNOWN_ASSIGNMENT_COMMAND +"\n",category.toUpperCase());
                    System.out.printf(Messages.VALID_POSSIBILITIES.toString(),"[COMMENT, COURSE, END, HOURS, NAME, POINTS, START]");
            }
            Printer.PrintItemProcessing(config,line,category,data,filename);
            line++;
        }

        if(course == null)
        {
            course = String.format(Messages.DEFAULT_UNSPECIFIED.toString(),"Course");
        }

        if(start == null)
        {
            System.out.printf(Messages.MISSING_ASSIGNMENT_ITEM.toString(),filename,"START");
            System.out.println();
        }

        if(end == null)
        {
            System.out.printf(Messages.MISSING_ASSIGNMENT_ITEM.toString(),filename,"END");
            System.out.println();
        }

        if(name == null)
        {
            System.out.printf(Messages.MISSING_ASSIGNMENT_ITEM.toString(),filename,"NAME");
            System.out.println();
        }

        if(hours == 0)
        {
            System.out.printf(Messages.MISSING_ASSIGNMENT_ITEM.toString(),filename,"HOURS");
            System.out.println();
        }

        return new Assignment(name,hours,start,end,course,points,comment);
    }

}
