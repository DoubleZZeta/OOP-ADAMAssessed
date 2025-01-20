package adam;

import java.util.Collections;
import java.util.List;

public class Configuration
{
    private final Truthy fileLoading;
    private final Truthy itemProcessing;
    private final List<String> comment;
    private final Truthy exitMessage;
    private final Truthy ignoreIncomplete;
    private final String now;
    private final OutputType outputType;
    private final List<Truthy> showComment;
    private final Truthy showConfig;
    private final Truthy welcomeMessage;

    public Configuration(Truthy fileLoading, Truthy itemProcessing, List<String> comment, Truthy exitMessage,
                         Truthy ignoreIncomplete, String now, OutputType outputType, List<Truthy> showComment,
                         Truthy showConfig, Truthy welcomeMessage   )
    {
        this.fileLoading = fileLoading;
        this.itemProcessing = itemProcessing;
        this.exitMessage = exitMessage;
        this.ignoreIncomplete = ignoreIncomplete;
        this.showComment = showComment;
        this.showConfig = showConfig;
        this.welcomeMessage = welcomeMessage;
        this.outputType = outputType;
        this.now = now;
        this.comment = comment;
    }

    public Truthy getFileLoading()
    {
        return this.fileLoading;
    }
    public Truthy getItemProcessing()
    {
        return this.itemProcessing;
    }
    public Truthy getExitMessage()
    {
        return this.exitMessage;
    }
    public Truthy getIgnoreIncomplete()
    {
        return this.ignoreIncomplete;
    }
    public List<Truthy> getShowComment()
    {
        return Collections.unmodifiableList(this.showComment);
    }
    public Truthy getShowConfig()
    {
        return this.showConfig;
    }
    public Truthy getWelcomeMessage()
    {
        return this.welcomeMessage;
    }
    public OutputType getOutputType()
    {
        return this.outputType;
    }
    public String getNow()
    {
        return this.now;
    }
    public List<String> getComments()
    {
        return Collections.unmodifiableList(this.comment);
    }







}
