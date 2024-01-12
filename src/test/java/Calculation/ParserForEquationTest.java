package Calculation;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static Calculation.ParserForEquation.*;
import static org.junit.jupiter.api.Assertions.*;

class ParserForEquationTest {

    @Test
    void parseTest1() {
        String expression = "((1+2)*(5-4)/2+(1-2))/2";
        Double result = null;
        try{
            result = parse(expression);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0.25, result, 0.000001);
    }

    @Test
    void parseTest2() {
        String expression = "8-9+7.8*(0-4)";
        Double result = null;
        try{
            result = parse(expression);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assertEquals(-32.2, result, 0.000001);
    }

    @Test
    void parseTest3() {
        String expression = "25/5-3*2+1";
        Double result = null;
        try{
            result = parse(expression);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0, result, 0.000001);
    }

    @Test
    void parseTest4() {
        String expression = "5-7*8";
        Double result = null;
        try{
            result = parse(expression);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assertEquals(-51, result, 0.000001);
    }

    @Test
    void parseTestExtraParenthesis()
    {
        String expression = "(4+5)*2/(3-5))";
        assertThrows(IllegalArgumentException.class,
                () -> ParserForEquation.parse(expression));
    }

    @Test
    void parseTestInvalidInputString1()
    {
        String expression = "(4&5)*2/(3-5)";
        assertThrows(ParseException.class,
                () -> ParserForEquation.parse(expression));
    }

    @Test
    void parseTestInvalidInputString2()
    {
        String expression = "$5";
        assertThrows(ParseException.class,
                () -> ParserForEquation.parse(expression));
    }

    @Test
    void parseTestDivisionByZero()
    {
        String expression = "(8-9)/0";
        assertThrows(ArithmeticException.class,
                () -> ParserForEquation.parse(expression));
    }

    @Test
    void isValidExpressionTest1() {
        String expression = "8-9+7.8*(0-4)";
        assertTrue(isValidExpression(expression));
    }

    @Test
    void isValidExpressionTest2() {
        String expression = "5-7*8";
        assertTrue(isValidExpression(expression));
    }

    @Test
    void isValidExpressionTestAdditionalOpenBracket() {
        String expression = "((9-6)*8";
        assertFalse(isValidExpression(expression));
    }

    @Test
    void isValidExpressionTestAdditionalCloseBracket() {
        String expression = "((1.0+2)*(5.78+(-4)))/(-2)+(0.7-0.8))/2";
        assertFalse(isValidExpression(expression));
    }
}