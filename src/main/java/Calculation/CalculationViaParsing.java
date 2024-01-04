package Calculation;

import static Calculation.InfixToPrefixWithParentheses.infixToPrefix;
import static Calculation.PolishNotation.evaluate;
import static Calculation.StringPreparationForParsing.preparation;

public class CalculationViaParsing {
    public static Double calculateViaParsing(String s)
    {
        String expression = preparation(s);
        expression = infixToPrefix(expression);
        Double result = evaluate(expression);
        return result;
    }
}
