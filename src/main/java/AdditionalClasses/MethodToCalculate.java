package AdditionalClasses;

public enum MethodToCalculate
{
    API ("Calculate via API"),
    FUNC ("Calculate via function"),
    REGEX ("Calculate via regex (parsing)");

    private String str;

    public String getChoice()
    {
        return str;
    }

    MethodToCalculate(String str)
    {
        this.str = str;
    }
}
