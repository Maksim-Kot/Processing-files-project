package Calculation;

import org.junit.jupiter.api.Test;


import static Calculation.CalculationViaRegex.calculateViaRegex;
import static org.junit.jupiter.api.Assertions.*;

class CalculationViaRegexTest {

    @Test
    void calculateViaRegexTest1() {
        String expression = "((1+2)*(5-4)/2+(1-2))/2";
        assertEquals(0.25, calculateViaRegex(expression), 0.000001);
    }

    @Test
    void calculateViaRegexTest2() {
        String expression = "( ( 0 - 1.0 + 2 ) * ( 5.78 + (- 4) ) / 2 + ( .7 - 0.8 ) ) / 2";
        assertEquals(0.395, calculateViaRegex(expression), 0.000001);
    }

    @Test
    void calculateViaRegexTest3() {
        String expression = "5 + 7*8";
        assertEquals(61, calculateViaRegex(expression), 0.000001);
    }

    @Test
    void calculateViaRegexTest4() {
        String expression = "25/5+3*2-1";
        assertEquals(10, calculateViaRegex(expression), 0.000001);
    }

    @Test
    void calculateViaRegexTestExtraParenthesis()
    {
        String expression = "(4 +5)*2/(3-5))";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaRegex.calculateViaRegex(expression));
    }

    @Test
    void calculateViaRegexTestInvalidOperator()
    {
        String expression = "(6 &   8) /5";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaRegex.calculateViaRegex(expression));
    }

    @Test
    void calculateViaRegexTestDivisionByZero()
    {
        String expression = "(6 +   8) /0";
        assertThrows(ArithmeticException.class,
                () -> CalculationViaRegex.calculateViaRegex(expression));
    }
}