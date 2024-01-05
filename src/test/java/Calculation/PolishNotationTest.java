package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.PolishNotation.*;
import static org.junit.jupiter.api.Assertions.*;

class PolishNotationTest
{

    @Test
    void evaluateTest1()
    {
        String s = "/ + / * + 1 2 - 5 4 2 - 1 2 2";
        assertEquals(0.25, evaluate(s), 0.000001);
    }

    @Test
    void evaluateTest2()
    {
        String s = "+ - 8 9 * 7.8 - 0 4";
        assertEquals(-32.2, evaluate(s), 0.000001);
    }

    @Test
    void evaluateTestInvalidOperator()
    {
        String s = "+ - 8 9 & 7.8 - 0 4";
        assertThrows(IllegalArgumentException.class,
                () -> PolishNotation.evaluate(s));
    }

    @Test
    void evaluateTestDivisionByZero()
    {
        String s = "+ - 8 9 / 7.8 0";
        assertThrows(ArithmeticException.class,
                () -> PolishNotation.evaluate(s));
    }

    @Test
    void isNumericTestDouble()
    {
        assertTrue(isNumeric("0.89"));
    }

    @Test
    void isNumericTestInteger()
    {
        assertTrue(isNumeric("5"));
    }

    @Test
    void isNumericTestDoubleWithoutIntegerPart()
    {
        assertTrue(isNumeric(".89"));
    }

    @Test
    void isNumericTestSymbol1()
    {
        assertFalse(isNumeric("*"));
    }

    @Test
    void isNumericTestSymbol2()
    {
        assertFalse(isNumeric("+"));
    }

    @Test
    void performOperationTestPlus1()
    {
        double operand1 = 5;
        double operand2 = 2.0;
        assertEquals(7.0, performOperation("+", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestPlus2()
    {
        double operand1 = 5.78;
        double operand2 = -4;
        assertEquals(1.78, performOperation("+", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestMinus1()
    {
        double operand1 = 8;
        double operand2 = 2.0;
        assertEquals(6, performOperation("-", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestMinus2()
    {
        double operand1 = 5.78;
        double operand2 = -4;
        assertEquals(9.78, performOperation("-", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestMinus3()
    {
        double operand1 = 4;
        double operand2 = 5.78;
        assertEquals(-1.78, performOperation("-", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestMul1()
    {
        double operand1 = 4;
        double operand2 = 5.78;
        assertEquals(23.12, performOperation("*", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestMul2()
    {
        double operand1 = 4;
        double operand2 = -6;
        assertEquals(-24, performOperation("*", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestDiv1()
    {
        double operand1 = 15;
        double operand2 = 7.5;
        assertEquals(2, performOperation("/", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestDiv2()
    {
        double operand1 = -7.5;
        double operand2 = 3.1;
        assertEquals(-2.4193548, performOperation("/", operand1, operand2), 0.000001);
    }

    @Test
    void performOperationTestInvalidOperator()
    {
        String invalidOperator = "&";
        double operand1 = 5.0;
        double operand2 = 2.0;
        assertThrows(IllegalArgumentException.class,
                () -> PolishNotation.performOperation(invalidOperator, operand1, operand2));
    }

    @Test
    void performOperationTestDivisionByZero()
    {
        double operand1 = 10.0;
        double operand2 = 0.0;
        assertThrows(ArithmeticException.class,
                () -> PolishNotation.performOperation("/", operand1, operand2));
    }
}