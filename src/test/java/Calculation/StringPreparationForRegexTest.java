package Calculation;

import org.junit.jupiter.api.Test;

import static Calculation.StringPreparationForRegex.deleteSeparators;
import static Calculation.StringPreparationForRegex.preparation;
import static org.junit.jupiter.api.Assertions.*;

class StringPreparationForRegexTest {

    @Test
    void preparationTest1()
    {
        String s = "(   0.   8-    1)*( -  4)/      (-8    )";
        assertEquals("(0.8-1)*(0-4)/(0-8)", preparation(s));
    }

    @Test
    void preparationTest2()
    {
        String s = "8-9+7.8*(-4)";
        assertEquals("8-9+7.8*(0-4)", preparation(s));
    }

    @Test
    void preparationTest3()
    {
        String s = "( b+ 7.8*       ( -4)  )* a";
        assertEquals("(b+7.8*(0-4))*a", preparation(s));
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
}