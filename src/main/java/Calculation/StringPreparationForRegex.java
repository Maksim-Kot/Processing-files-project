package Calculation;

public class StringPreparationForRegex
{
    public static String preparation(String s)
    {
        s = StringPreparationForFunction.preparation(s);
        s = deleteSeparators(s);
        return s;
    }
    static String deleteSeparators(String s)
    {
        return s.replaceAll("\\s+", "");
    }
}
