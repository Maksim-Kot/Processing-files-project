package Calculation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserForEquation
{
    private static final String regexBr = "\\(([1234567890\\.\\+\\-\\*\\/^%]*)\\)";
    private static final String regexNum = "[-]?\\d+\\.?\\d*";
    private static final String regexMulOp = "[\\*\\/^%]";
    private static final String regexAddOp = "[\\+\\-]";

    public static double parse(String str) throws ParseException
    {
        if(!isValidExpression(str))
        {
            throw new IllegalArgumentException("Invalid expression: extra parenthesis");
        }
        // Parse parentheses
        Pattern patternSk = Pattern.compile(regexBr);
        Matcher matchSk = patternSk.matcher(str);
        if (matchSk.find())
        {
            String inner = matchSk.group(1);
            String left = str.substring(0, matchSk.start());
            String right = str.substring(matchSk.end());

            return parse(left + parse(inner) + right);
        }

        // Parsing actions
        Pattern patternMulOp = Pattern.compile("(" + regexNum + ")\\s?(" + regexMulOp + ")\\s?(" + regexNum + ")\\s?");
        Pattern patternAddOp = Pattern.compile("(" + regexNum + ")\\s?(" + regexAddOp + ")\\s?(" + regexNum + ")\\s?");
        Matcher matchMulOp = patternMulOp.matcher(str);
        Matcher matchAddOp = patternAddOp.matcher(str);
        Matcher match = matchMulOp.find() ? matchMulOp : matchAddOp.find() ? matchAddOp : null;
        if (match != null)
        {
            String left = str.substring(0, match.start());
            String right = str.substring(match.end());
            return parse(left + parseAct(match) + right);
        }

        // Parse numbers
        try
        {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.');
            DecimalFormat format = new DecimalFormat("#.#####", symbols);
            return format.parse(str).doubleValue();
        } catch (NumberFormatException | ParseException e)
        {
            throw new ParseException("Invalid input string: '" + str + "'", 0);
        }
    }

    private static double parseAct(Matcher match) throws ParseException
    {
        double a = Double.parseDouble(match.group(1));
        double b = Double.parseDouble(match.group(3));

        switch (match.group(2))
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is impossible");
                }
                return a / b;
            default:
                throw new ParseException("Invalid input string: '" + match.group() + "'", 0);
        }
    }

    public static boolean isValidExpression(String expression)
    {
        // Check for the presence of the same number of opening and closing parentheses
        int openParentheses = expression.length() - expression.replace("(", "").length();
        int closeParentheses = expression.length() - expression.replace(")", "").length();
        return openParentheses == closeParentheses;
    }
}
