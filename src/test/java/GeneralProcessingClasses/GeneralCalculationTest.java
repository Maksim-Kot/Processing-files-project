package GeneralProcessingClasses;

import AdditionalClasses.MethodToCalculate;
import EquationClass.MathEquation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralCalculationTest {

    @Test
    void calculateTestAPI() {
        MethodToCalculate methodToCalculate = MethodToCalculate.API;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        MathEquation test = new MathEquation("2     * a", "a = 4", 8.0);
        List<MathEquation> res = generalCalculation.calculate(eq, methodToCalculate);
        assertEquals(test, res.get(0));
    }

    @Test
    void calculateTestFUNC() {
        MethodToCalculate methodToCalculate = MethodToCalculate.FUNC;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        MathEquation test = new MathEquation("2     * a", "a = 4", 8.0);
        List<MathEquation> res = generalCalculation.calculate(eq, methodToCalculate);
        assertEquals(test, res.get(0));
    }

    @Test
    void calculateTestREGEX() {
        MethodToCalculate methodToCalculate = MethodToCalculate.REGEX;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        MathEquation test = new MathEquation("2     * a", "a = 4", 8.0);
        List<MathEquation> res = generalCalculation.calculate(eq, methodToCalculate);
        assertEquals(test, res.get(0));
    }

    @Test
    void isHaveMistakesTestConstructor() {
        GeneralCalculation generalCalculation = new GeneralCalculation();
        assertFalse(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithMistakeAPI() {
        MethodToCalculate methodToCalculate = MethodToCalculate.API;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertTrue(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithMistakeFUNC() {
        MethodToCalculate methodToCalculate = MethodToCalculate.FUNC;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertTrue(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithMistakeREGEX() {
        MethodToCalculate methodToCalculate = MethodToCalculate.REGEX;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertTrue(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithNoMistakeAPI() {
        MethodToCalculate methodToCalculate = MethodToCalculate.API;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertFalse(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithNoMistakeFUNC() {
        MethodToCalculate methodToCalculate = MethodToCalculate.FUNC;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertFalse(generalCalculation.isHaveMistakes());
    }

    @Test
    void isHaveMistakesTestWithNOMistakeREGEX() {
        MethodToCalculate methodToCalculate = MethodToCalculate.REGEX;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertFalse(generalCalculation.isHaveMistakes());
    }

    @Test
    void getMistakesTestAPI() {
        MethodToCalculate methodToCalculate = MethodToCalculate.API;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     / a", "a = 0", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertEquals("Number (3): Invalid expression format", generalCalculation.getMistakes().get(0));
    }

    @Test
    void getMistakesTestFUNC() {
        MethodToCalculate methodToCalculate = MethodToCalculate.FUNC;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8&b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertEquals("Number (2): Invalid operator: &", generalCalculation.getMistakes().get(0));
        assertEquals("Number (3): Invalid expression format", generalCalculation.getMistakes().get(1));
    }

    @Test
    void getMistakesTestREGEX() {
        MethodToCalculate methodToCalculate = MethodToCalculate.REGEX;
        GeneralCalculation generalCalculation = new GeneralCalculation();
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     / a", "a = 0", 0.0));
        generalCalculation.calculate(eq, methodToCalculate);
        assertEquals("Number (3): Invalid expression format", generalCalculation.getMistakes().get(0));
        assertEquals("Number (4): Division by zero is impossible", generalCalculation.getMistakes().get(1));
    }
}