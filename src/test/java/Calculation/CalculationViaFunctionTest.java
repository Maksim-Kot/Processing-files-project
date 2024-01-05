package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.CalculationViaFunction.calculateViaFunction;
import static org.junit.jupiter.api.Assertions.*;

class CalculationViaFunctionTest
{

    @Test
    void calculateViaFunctionTest1()
    {
        String expression = "((1+2)*(5-4)/2+(1-2))/2";
        assertEquals(0.25, calculateViaFunction(expression), 0.000001);
    }

    @Test
    void calculateViaFunctionTest2()
    {
        String expression = "   8  - 9+ 7.8*    (-4)";
        assertEquals(-32.2, calculateViaFunction(expression), 0.000001);
    }

    @Test
    void calculateViaFunctionTestExtraParenthesis()
    {
        String expression = "(4 +5)*2/(3-5))";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaFunction.calculateViaFunction(expression));
    }

    @Test
    void calculateViaFunctionTestInvalidOperator()
    {
        String expression = "(6 &   8) /5";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaFunction.calculateViaFunction(expression));
    }

    @Test
    void performOperationTestDivisionByZero()
    {
        String expression = "(6 +   8) /0";
        assertThrows(ArithmeticException.class,
                () -> CalculationViaFunction.calculateViaFunction(expression));
    }
}