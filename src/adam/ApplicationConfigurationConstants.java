package adam;

import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApplicationConfigurationConstants {
  public static final int DECIMAL_PLACES = 1;

  public static final RoundingMode ROUNDING_MODE = RoundingMode.UP;

  public static final String DEFAULT_TIMEZONE = "Europe/London";

  public static final ZonedDateTime DEFAULT_NOW =
      ZonedDateTime.of(2024, 4, 29, 9, 0, 0, 0, ZoneId.of(DEFAULT_TIMEZONE));

  public static final String NOT_SHOWING = "FALSE";

  public static final String SHOWING = "TRUE";

  public static final boolean DEFAULT_ASSIGNMENT_FILE_LOADING = true;

  public static final boolean DEFAULT_ASSIGNMENT_ITEM_PROCESSING = true;

  public static final boolean DEFAULT_SHOW_EXIT_MESSAGE = false;

  public static final boolean DEFAULT_SHOW_WELCOME_MESSAGE = true;

  public static final boolean DEFAULT_IGNORE_INCOMPLETE_ASSIGNMENTS = false;

  public static final boolean DEFAULT_SHOW_COMMENTS = true;

  public static final boolean DEFAULT_SHOW_CONFIG_STATUS = false;

  public static final String DEFAULT_OUTPUT_TYPE = "SUMMARY";

  public static final int DEFAULT_POINTS = 0;
}
