import adam.ADAM;

import static adam.Utils.areBasicChecksPassed;

// You MUST NOT edit this class because it wil be replaced by the automarker
public class Runner {

  // At least one command-line argument specifying an assignment configuration is required
  public static void main(String[] args) {
    if ( areBasicChecksPassed(args) ) {
      ADAM app = new ADAM(args);
      app.run();
    } else {
      System.err.println("Basics checks failed: use the debugger to see which and why");
    }
  }
}
