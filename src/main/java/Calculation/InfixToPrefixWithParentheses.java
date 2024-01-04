package Calculation;

import java.util.Stack;

public class InfixToPrefixWithParentheses
{
    public static String infixToPrefix(String infixExpression)
    {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        String[] tokens = infixExpression.split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--)
        {
            String token = tokens[i];
            char firstChar = token.charAt(0);

            if (Character.isDigit(firstChar))
            {
                prefix.insert(0, token).insert(0, " ");
            } else if (firstChar == ')')
            {
                operatorStack.push(firstChar);
            } else if (isOperator(firstChar))
            {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '('
                        && precedence(operatorStack.peek()) > precedence(firstChar))
                {
                    prefix.insert(0, operatorStack.pop()).insert(0, " ");
                }
                operatorStack.push(firstChar);
            } else if (firstChar == '(')
            {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')')
                {
                    prefix.insert(0, operatorStack.pop()).insert(0, " ");
                }
                if (!operatorStack.isEmpty())
                {
                    operatorStack.pop();
                } else
                {
                    throw new IllegalArgumentException("Invalid expression: extra opening parenthesis");
                }
            }
        }

        while (!operatorStack.isEmpty())
        {
            char top = operatorStack.pop();
            if (top == '(' || top == ')')
            {
                throw new IllegalArgumentException("Invalid expression: extra parenthesis");
            }
            prefix.insert(0, top).insert(0, " ");
        }

        return prefix.toString().trim();
    }

    public static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int precedence(char operator)
    {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return 0; // Priority of parentheses
        }
        return -1;
    }
}
