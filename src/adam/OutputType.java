package adam;

public enum OutputType
{
    SUMMARY
    {
        @Override
        public String toString() {return "SUMMARY";}
    },
    DAILY
    {
        @Override
        public String toString() {return "DAILY";}
    };
}
