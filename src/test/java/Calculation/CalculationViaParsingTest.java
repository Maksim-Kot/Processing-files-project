package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.CalculationViaParsing.calculateViaParsing;
import static org.junit.jupiter.api.Assertions.*;

class CalculationViaParsingTest
{

    @Test
    void calculateViaParsingTest1()
    {
        String expression = "((1+2)*(5-4)/2+(1-2))/2";
        assertEquals(0.25, calculateViaParsing(expression), 0.000001);
    }

    @Test
    void calculateViaParsingTest2()
    {
        String expression = "   8  - 9+ 7.8*    (-4)";
        assertEquals(-32.2, calculateViaParsing(expression), 0.000001);
    }

    @Test
    void calculateViaParsingTestExtraParenthesis()
    {
        String expression = "(4 +5)*2/(3-5))";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaParsing.calculateViaParsing(expression));
    }

    @Test
    void calculateViaParsingTestInvalidOperator()
    {
        String expression = "(6 &   8) /5";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaParsing.calculateViaParsing(expression));
    }

    @Test
    void performOperationTestDivisionByZero()
    {
        String expression = "(6 +   8) /0";
        assertThrows(ArithmeticException.class,
                () -> CalculationViaParsing.calculateViaParsing(expression));
    }
}