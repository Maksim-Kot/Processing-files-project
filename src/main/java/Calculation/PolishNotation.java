package Calculation;

import java.util.Stack;

public class PolishNotation
{
    public static double evaluate(String expression)
    {
        String[] tokens = expression.split("\\s+");
        Stack<Double> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--)
        {
            String token = tokens[i];
            if (isNumeric(token))
            {
                stack.push(Double.parseDouble(token));
            } else
            {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double value = performOperation(token, operand1, operand2);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static double performOperation(String operator, double operand1, double operand2)
    {
        switch (operator)
        {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0)
                {
                    throw new ArithmeticException("Division by zero is impossible");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("\n" + "Invalid operator: " + operator);
        }
    }
}
