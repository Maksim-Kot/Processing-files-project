package Calculation;

import java.text.ParseException;

import static Calculation.ParserForEquation.parse;

public class CalculationViaRegex
{
    public static Double calculateViaRegex(String s)
    {
        String expression = StringPreparationForRegex.preparation(s);
        Double result = null;
        try {
            result = parse(expression);
        } catch (ParseException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        } catch (ArithmeticException e)
        {
            throw new ArithmeticException(e.getMessage());
        }
        return result;
    }
}
