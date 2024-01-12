package AdditionalClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodToCalculateTest {

    @Test
    void getChoiceTestAPI() {
        MethodToCalculate methodToCalculate = MethodToCalculate.API;
        assertEquals("Calculate via API", methodToCalculate.getChoice());
    }

    @Test
    void getChoiceTestFUNC() {
        MethodToCalculate methodToCalculate = MethodToCalculate.FUNC;
        assertEquals("Calculate via function", methodToCalculate.getChoice());
    }

    @Test
    void getChoiceTestREGEX() {
        MethodToCalculate methodToCalculate = MethodToCalculate.REGEX;
        assertEquals("Calculate via regex (parsing)", methodToCalculate.getChoice());
    }
}