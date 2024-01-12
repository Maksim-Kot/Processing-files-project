package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.CalculationViaAPI.calculateViaAPI;
import static org.junit.jupiter.api.Assertions.*;

class CalculationViaAPITest {


    @Test
    void calculateViaAPITest1()
    {
        String expression = "((1+2)*(5-4)/2+(1-2))/2";
        assertEquals(0.25, calculateViaAPI(expression), 0.000001);
    }

    @Test
    void calculateViaAPITest2()
    {
        String expression = "   8  - 9+ 7.8*    (-4)";
        assertEquals(-32.2, calculateViaAPI(expression), 0.000001);
    }

    @Test
    void calculateViaAPITestExtraParenthesis()
    {
        String expression = "(4 +5)*2/(3-5))";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaAPI.calculateViaAPI(expression));
    }

    @Test
    void calculateViaAPITestInvalidOperator()
    {
        String expression = "(6 &   8) /5";
        assertThrows(IllegalArgumentException.class,
                () -> CalculationViaAPI.calculateViaAPI(expression));
    }

    @Test
    void calculateViaAPITestDivisionByZero1()
    {
        String expression = "(6 +   8) /0";
        assertEquals(Double.POSITIVE_INFINITY, calculateViaAPI(expression), 0.000001);
    }

    @Test
    void calculateViaAPITestDivisionByZero2()
    {
        String expression = "(6 -   8) /0";
        assertEquals(Double.NEGATIVE_INFINITY, calculateViaAPI(expression), 0.000001);
    }
}