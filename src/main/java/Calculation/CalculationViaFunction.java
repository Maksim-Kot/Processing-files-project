package Calculation;

import static Calculation.InfixToPrefixWithParentheses.infixToPrefix;
import static Calculation.PolishNotation.evaluate;
import static Calculation.StringPreparationForFunction.preparation;

public class CalculationViaFunction {
    public static Double calculateViaFunction(String s)
    {
        String expression = preparation(s);
        expression = infixToPrefix(expression);
        Double result = evaluate(expression);
        return result;
    }
}
