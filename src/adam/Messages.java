package adam;

// You MAY edit this class but are advised to do so carefully
public enum Messages {
  EXIT {
    @Override
    public String toString() {return String.format("%nGoodbye%n");}
  },
  WELCOME { // TODO Get from another class: use obfuscated

    @Override
    public String toString() {return "Greetings";}
  },
  APPLICATION_COMMENT {
    @Override
    public String toString() {return "Comment: %s";}
  },
  APPLICATION_SETTINGS {
    @Override
    public String toString() {return "Application settings";}
  },
  TOTAL_TOP_LINE {
    @Override
    public String toString() {return "-".repeat(TOTAL_LINE_SIZE);}
  },
  DAILY_TOTAL {
    @Override
    public String toString() {return "%2.1f total hours";}
  },
  TOTAL_BOTTOM_LINE {
    @Override
    public String toString() {return "=".repeat(TOTAL_LINE_SIZE);}
  },
  DEFAULT_UNSPECIFIED {
    @Override
    public String toString() {return "(%s not specified)";}
  },
  DEFAULT_COURSE {
    @Override
    public String toString() {
      return String.format(DEFAULT_UNSPECIFIED.toString(), "Course");
    }
  },
  DEFAULT_HOURS {
    @Override
    public String toString() {
      return String.format(DEFAULT_UNSPECIFIED.toString(), "Assignment hours");
    }
  },
  DEFAULT_NAME {
    @Override
    public String toString() {
      return String.format(DEFAULT_UNSPECIFIED.toString(), "Assignment name");
    }
  },
  DEFAULT_START {
    @Override
    public String toString() {
      return String.format(DEFAULT_UNSPECIFIED.toString(), "Assignment start");
    }
  },
  DEFAULT_END {
    @Override
    public String toString() {
      return String.format(DEFAULT_UNSPECIFIED.toString(), "Assignment end");
    }
  },
  DEFAULT_POINTS {
    @Override
    public String toString() {
      return String.valueOf(ApplicationConfigurationConstants.DEFAULT_POINTS);
    }
  },
  DEFAULT_COMMENT {
    @Override
    public String toString() {return "";}
  },
  HOURS_ON {
    @Override
    public String toString() {return "%2.1f hours on \"%s\" %s";}
  },
  INVALID_APP_CONFIG_ITEM {
    @Override
    public String toString() {
      return "\"%s\" is not a valid application configuration";
    }
  },
  INVALID_SUMMARY_TYPE {
    @Override
    public String toString() {
      return "\"%s\" is not a valid summary type; valid types are %s";
    }
  },
  INVALID_ZTD {
    @Override
    public String toString() {
      return "\"%s\" is not a valid zoned date and time";
    }
  },
  INVALID_ZTD_DEFAULT {
    @Override
    public String toString() {
      return String.format("%s\t%s", INVALID_ZTD, USING_INSTEAD);
    }
  },
  LOADING_ASSIGNMENT {
    @Override
    public String toString() {return "Loading assignment from %s";}
  },
  MISSING_ASSIGNMENT_ITEM {
    @Override
    public String toString() {
      return "Assignment configuration %s is missing the %s command";
    }
  },
  NO_ASSIGNMENTS {
    @Override
    public String toString() {
      return "No assignments have been loaded successfully";
    }
  },
  OVERWRITING_APP_CONFIG_ITEM {
    @Override
    public String toString() {return "Overwriting %s (%s) with %s";}
  },
  READ_CONFIGURATION_ITEM {
    @Override
    public String toString() {return "Read configuration item %s";}
  },
  REMAINING_DAYS {
    @Override
    public String toString() {return "Remaining days: %3d%n";}
  },
  SETTING_APP_CONFIG_ITEM {
    @Override
    public String toString() {return "Setting %s to %s";}
  },
  TIMETABLE_SUMMARY {
    @Override
    public String toString() {
      return "Assignment \"%s\" for %s:%n\t%2.0f hours per day, %3d days until the deadline of %s";
    }
  },
  UNKNOWN_ASSIGNMENT_COMMAND {
    @Override
    public String toString() {
      return "\"%s\" is not a valid assignment command";
    }
  },
  USING_INSTEAD {
    @Override
    public String toString() {return "using %s instead";}
  },
  VALID_POSSIBILITIES {
    @Override
    public String toString() {return "Valid possibilities are %s";}
  };

  private final static int TOTAL_LINE_SIZE = 16;
}
