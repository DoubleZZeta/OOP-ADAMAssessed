package adam;

import java.util.ArrayList;
import java.util.List;

public class ADAM
{

  protected final String[] args;

  // You MUST NOT edit the signature of this constructor
  public ADAM(String[] args)
  {
    // You MAY edit the body of this constructor
    this.args = args;
  }
  private static Configuration processConfig()
  {
    List<String> input = ReadStream.newRead();
    List<SplitInput> splitInput = ProcessInput.splitInput(input);
    return ProcessConfigCategory.processCategories(splitInput);
  }

  private static void getFile(String[] paths)
  {
    for(String path: paths)
    {
      System.out.println(ReadFile.getFile(path));
    }
  }
  private static List<Assignment> processAssignment(String[] paths, Configuration config)
  {
    List<Assignment> assignments = new ArrayList<>();
    for(String path: paths)
    {
      String fileName = path.split("/")[path.split("/").length-1];
      Printer.PrintFileLoading(config,fileName);
      List<String> input = ReadFile.read(path);
      List<SplitInput> splitInput = ProcessInput.splitInput(input);
      Assignment assignment = ProcessAssignmentCategory.processCategories(splitInput,config,fileName);
      if(assignment.getComplete())
      {
        assignments.add(assignment);
      }
    }
    return assignments;
  }
  // You MUST NOT edit the signature of this method
  public void run()
  {
    // You MUST edit the body of this constructor
    Configuration config = processConfig();
    Printer.PrintConfigurationComment(config);
    Printer.PrintConfigStatus(config);
    Printer.PrintWelcomeMessage(config);
    List<Assignment> assignments = processAssignment(this.args,config);
    if(assignments.isEmpty())
    {
      System.out.println(Messages.NO_ASSIGNMENTS);
    }
    else
    {
      if(config.getOutputType().equals(OutputType.SUMMARY))
      {
        Printer.PrintSummary(assignments,config);
      }
      else
      {
        Printer.PrintDaily(assignments,config);
      }
    }
    Printer.PrintExitMessage(config);
//    getFile(this.args);
  }

}
