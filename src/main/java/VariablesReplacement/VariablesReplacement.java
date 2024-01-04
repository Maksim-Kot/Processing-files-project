package VariablesReplacement;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariablesReplacement
{
    public static String replaceVariables(String expression, String variables)
    {
        HashMap<String, Double> values = getVariableValues(variables);

        // Check for additional features coming soon
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find())
        {
            String var = matcher.group();
            if (!values.containsKey(var))
            {
                throw new IllegalArgumentException("Missing value for variable: " + var);
            }
        }

        for (String value : values.keySet())
        {
            if(values.get(value) < 0)
            {
                expression = expression.replaceAll(value, "(" + values.get(value).toString() + ")");
            }
            else expression = expression.replaceAll(value, values.get(value).toString());
        }

        return expression;
    }
    public static HashMap<String, Double> getVariableValues(String values)
    {
        HashMap<String, Double> variables = new HashMap<>();
        String[] assignments = values.split(",");

        for (String assignment : assignments)
        {
            String[] parts = assignment.split("=");
            if (parts.length != 2) {
                throw new NumberFormatException("Invalid expression format");
            }
            String variable = parts[0].trim();
            Double value = Double.parseDouble(parts[1].trim());
            variables.put(variable, value);
        }

        return variables;
    }
}
