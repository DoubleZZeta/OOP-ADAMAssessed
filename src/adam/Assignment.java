package adam;

import javax.sound.midi.MidiDevice;
import java.time.Duration;
import java.time.ZonedDateTime;

public class Assignment
{
    private final String name;
    private final double hours;
    private final ZonedDateTime start;
    private final ZonedDateTime end;
    private final String course;
    private final double points;
    private final String comment;
    public Assignment(String name, double hours, ZonedDateTime start, ZonedDateTime end, String course, double points, String comment)
    {
        this.name = name;
        this.hours = hours;
        this.start = start;
        this.end = end;
        this.course = course;
        this.points = points;
        this.comment = comment;
    }
    public String getName()
    {
        return this.name;
    }
    public double getHours()
    {
        return this.hours;
    }
    public ZonedDateTime getStart()
    {
        return this.start;
    }
    public ZonedDateTime getEnd()
    {
        return this.end;
    }
    public String getCourse()
    {
        return this.course;
    }
    public double getPoints()
    {
        return this.points;
    }
    public String getComment()
    {
        return this.comment;
    }
    public long getDuration()
    {
        if (Duration.between(getStart(),getEnd()).isNegative())
        {
            return Duration.between(getStart(),getStart()).toDays();
        }
        else
        {
            if (getEnd().getHour()-1 == 0)
            {
                return Duration.between(getStart(),getEnd()).toDays();
            }
            else
            {
                return Duration.between(getStart(),getEnd()).toDays()+1;
            }

        }
    }
    public double getHoursPerDay()
    {
        if(this.hours != 0)
        {
            return getHours()/(getDuration());
        }
        else
        {
            return 0;
        }
    }
    public boolean getComplete()
    {
        return (getName() != null) && (getHours() != 0) && (getStart() != null) && (getEnd() != null);
    }
    public String toString(OutputType outputType)
    {
        if (outputType.equals(OutputType.SUMMARY))
        {
            return String.format(Messages.TIMETABLE_SUMMARY.toString(),getName(),getCourse(),getHoursPerDay(),getDuration(),getEnd().toString());
        }
        else
        {
            return String.format(Messages.HOURS_ON.toString(),getHoursPerDay(),getName(),getCourse());
        }
    }
}
