package VariablesReplacement;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static VariablesReplacement.VariablesReplacement.getVariableValues;
import static VariablesReplacement.VariablesReplacement.replaceVariables;
import static org.junit.jupiter.api.Assertions.*;

class VariablesReplacementTest {

    @Test
    void replaceVariablesTest1() {
        String expression = "(a-b)*2";
        String variables = "a=8, b = 7";
        assertEquals("(8.0-7.0)*2", replaceVariables(expression, variables));
    }

    @Test
    void replaceVariablesTest2() {
        String expression = "x*y";
        String variables = "x=8.6, y =9.78";
        assertEquals("8.6*9.78", replaceVariables(expression, variables));
    }

    @Test
    void replaceVariablesTestMissingVariable() {
        String expression = "x*y";
        String variables = "x=8.6, b =9.78";
        assertThrows(IllegalArgumentException.class,
                () -> VariablesReplacement.replaceVariables(expression, variables));
    }

    @Test
    void replaceVariablesTestInvalidFormat1() {
        String expression = "x*y";
        String variables = "x=8.6, y";
        assertThrows(NumberFormatException.class,
                () -> VariablesReplacement.replaceVariables(expression, variables));
    }

    @Test
    void replaceVariablesTestInvalidFormat2() {
        String expression = "x*y";
        String variables = "x=8.6, y = 7 = 8";
        assertThrows(NumberFormatException.class,
                () -> VariablesReplacement.replaceVariables(expression, variables));
    }

    @Test
    void getVariableValuesTestInvalidFormat1() {
        String variables = "x=8.6, y = 7 = 8";
        assertThrows(NumberFormatException.class,
                () -> VariablesReplacement.getVariableValues(variables));
    }

    @Test
    void getVariableValuesTestInvalidFormat2() {
        String variables = "x=8.6, d";
        assertThrows(NumberFormatException.class,
                () -> VariablesReplacement.getVariableValues(variables));
    }

    @Test
    void getVariableValuesTest1() {
        String variables = "x=8.6";
        HashMap<String, Double> needed = new HashMap<>();
        needed.put("x", 8.6);
        HashMap<String, Double> res = getVariableValues(variables);
        assertEquals(needed, res);
    }

    @Test
    void getVariableValuesTest2() {
        String variables = "x=8.6, d = 0.9, u= 6";
        HashMap<String, Double> needed = new HashMap<>();
        needed.put("x", 8.6);
        needed.put("d", 0.9);
        needed.put("u", 6.0);
        HashMap<String, Double> res = getVariableValues(variables);
        assertEquals(needed, res);
    }
}