package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.InfixToPrefixWithParentheses.*;
import static org.junit.jupiter.api.Assertions.*;

class InfixToPrefixWithParenthesesTest
{

    @Test
    void infixToPrefixTest1()
    {
        String s = "8 - 9 + 7.8 * ( 0 - 4 )";
        assertEquals("+ - 8 9 * 7.8 - 0 4", infixToPrefix(s));
    }

    @Test
    void infixToPrefixTest2()
    {
        String s = "( ( 0 - 1.0 + 2 ) * ( 5.78 + ( 0 - 4 ) ) / 2 + ( 0.7 - 0.8 ) ) / 2";
        assertEquals("/ + / * + - 0 1.0 2 + 5.78 - 0 4 2 - 0.7 0.8 2", infixToPrefix(s));
    }

    @Test
    void infixToPrefixTest3()
    {
        String s = "( ( 1 + 2 ) * ( 5 - 4 ) / 2 + ( 1 - 2 ) ) / 2";
        assertEquals("/ + / * + 1 2 - 5 4 2 - 1 2 2", infixToPrefix(s));
    }

    @Test
    void infixToPrefixTestExtraParenthesis()
    {
        String s = "( ( 1 + 2 ) * ( 5 - 4 ) / 2 + ( 1 - 2 ) ) ) / 2";
        assertThrows(IllegalArgumentException.class,
                () -> InfixToPrefixWithParentheses.infixToPrefix(s));
    }

    @Test
    void infixToPrefixTestInvalidOperator()
    {
        String s = "( ( 1 + 2 ) * ( 5 - 4 ) & 2 + ( 1 - 2 ) ) ) / 2";
        assertThrows(IllegalArgumentException.class,
                () -> InfixToPrefixWithParentheses.infixToPrefix(s));
    }

    @Test
    void isOperatorTestPlus()
    {
       assertTrue(isOperator('+'));
    }

    @Test
    void isOperatorTestMinus()
    {
        assertTrue(isOperator('-'));
    }

    @Test
    void isOperatorTestMul()
    {
        assertTrue(isOperator('*'));
    }

    @Test
    void isOperatorTestDiv()
    {
        assertTrue(isOperator('/'));
    }

    @Test
    void isOperatorTestSymbol1()
    {
        assertFalse(isOperator('.'));
    }

    @Test
    void isOperatorTestSymbol2()
    {
        assertFalse(isOperator('4'));
    }

    @Test
    void precedenceTestPlus()
    {
        assertEquals(1, precedence('+'));
    }

    @Test
    void precedenceTestMinus()
    {
        assertEquals(1, precedence('-'));
    }

    @Test
    void precedenceTestMul()
    {
        assertEquals(2, precedence('*'));
    }

    @Test
    void precedenceTestDiv()
    {
        assertEquals(2, precedence('/'));
    }

    @Test
    void precedenceTestOpeningParenthesis()
    {
        assertEquals(0, precedence('('));
    }

    @Test
    void precedenceTestClosingParenthesis()
    {
        assertEquals(0, precedence(')'));
    }

    @Test
    void precedenceTestSymbol1()
    {
        assertEquals(-1, precedence('.'));
    }

    @Test
    void precedenceTestSymbol2()
    {
        assertEquals(-1, precedence('8'));
    }
}