package adam;

import java.io.FileInputStream;
import java.io.IOException;

// You MUST NOT edit this class because it wil be replaced by the automarker
public class Utils {
  private static final int JDK_REQUIRED = 17;

  private static final int MIN_NUMBER_ARGS = 1;

  private Utils() {}

  /**
   * Finds the major version of the JDK. Doesn't work for really early
   * versions of Java.
   *
   * @return The major version of the JDK being used
   */
  public static int getJavaVersion() {
    return Integer.parseInt(System.getProperty("java.version")
                                  .split("\\.")[0]);
  }

  public static boolean jdkAcceptable() {
    return getJavaVersion() == JDK_REQUIRED;
  }

  /**
   * The number of command-line arguments must be acceptable.
   * Acceptable is measured against the required minimum number of arguments.
   *
   * @param args
   * @return
   */
  public static boolean argsLengthOK(String[] args) {
    return args.length >= MIN_NUMBER_ARGS;
  }

  /**
   * Perform basic checks on a file: whether it exists, is readable, and is not empty.
   *
   * @param filename the name of the file to check: the path can be relative
   *                 or absolute but should ideally be constructed in a
   *                 platform-independent format
   * @return whether the file exists, is readable, and is not empty
   */
  public static boolean fileOK(String filename) {
    boolean ok;

    try ( final FileInputStream fis = new FileInputStream(filename) ) {
      // check file is not empty by reading something
      ok = fis.read() != -1;
    } catch ( IOException e ) {ok = false;}

    return ok;
  }

  /**
   * Checks all provided files are ok by utilising {@link this.fileOK}
   *
   * @param fileList
   * @return
   */
  public static boolean filesOK(String[] fileList) {
    for ( String file : fileList ) {
      if ( !fileOK(file) ) {return false;}
    }

    return true;
  }

  public static boolean areBasicChecksPassed(String[] args) {
    return ( jdkAcceptable() && argsLengthOK(args) && filesOK(args) );
  }
}
