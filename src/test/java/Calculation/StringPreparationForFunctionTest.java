package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.StringPreparationForFunction.*;
import static org.junit.jupiter.api.Assertions.*;

class StringPreparationForFunctionTest
{

    @Test
    void preparationTest1()
    {
        String s = "(   0.   8-    1)*( -  4)/      (-8    )";
        assertEquals("( 0.8 - 1 ) * ( 0 - 4 ) / ( 0 - 8 )", preparation(s));
    }

    @Test
    void preparationTest2()
    {
        String s = "8-9+7.8*(-4)";
        assertEquals("8 - 9 + 7.8 * ( 0 - 4 )", preparation(s));
    }

    @Test
    void deleteSeparatorsTest1()
    {
        String s = "(    4.5 +a) * b +    6 ";
        assertEquals("(4.5+a)*b+6", deleteSeparators(s));
    }

    @Test
    void deleteSeparatorsTest2()
    {
        String s = "(    0.78 +a) /     6 +    (-4)";
        assertEquals("(0.78+a)/6+(-4)", deleteSeparators(s));
    }

    @Test
    void handlingNumbersTest()
    {
        String s = "((4.7-7)*8-7.6)/2";
        assertEquals("( ( 4.7 - 7 ) * 8 - 7.6 ) / 2", handlingNumbers(s));
    }

    @Test
    void handlingNumbersTestDoubleWithoutIntegerPart()
    {
        String s = "(4-6)*4-(.9+5)";
        assertEquals("( 4 - 6 ) * 4 - ( 0.9 + 5 )", handlingNumbers(s));
    }

    @Test
    void handlingNumbersTestWithNegativeNumber()
    {
        String s = "(0.8-1)*(-4)/(-8)";
        assertEquals("( 0.8 - 1 ) * ( 0 - 4 ) / ( 0 - 8 )", handlingNumbers(s));
    }

    @Test
    void handlingNumbersTestAllSituation()
    {
        String s = "((.8-1)*(-4)+5.8)/(-6)";
        assertEquals("( ( 0.8 - 1 ) * ( 0 - 4 ) + 5.8 ) / ( 0 - 6 )", handlingNumbers(s));
    }
}