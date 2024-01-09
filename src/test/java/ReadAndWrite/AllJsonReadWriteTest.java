package ReadAndWrite;

import Calculation.InfixToPrefixWithParentheses;
import EquationClass.MathEquation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ReadAndWrite.JsonReadWrite.readFromJSONFile;
import static ReadAndWrite.JsonReadWrite.writeToJSONFile;
import static ReadAndWrite.MyJsonReadWrite.myReadFromJSONFile;
import static ReadAndWrite.MyJsonReadWrite.myWriteToJSONFile;
import static org.junit.jupiter.api.Assertions.*;

class AllJsonReadWriteTest {

    @Test
    void readFromJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = readFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void readFromJSONFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = readFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void readFromJSONFileNoFound() {
        assertThrows(RuntimeException.class,
                () -> JsonReadWrite.readFromJSONFile("test.json"));
    }

    @Test
    void readFromJSONFileInvalidInformation() {
        File fileToCreate = new File("test.json");
        try {
            fileToCreate.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalArgumentException.class,
                () -> JsonReadWrite.readFromJSONFile("test.json"));
    }

    @Test
    void writeToJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = readFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void writeToJSONFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void writeToJSONFileInvalidPath() {
        List<MathEquation> equations = new ArrayList<>();
        assertThrows(RuntimeException.class,
                () -> JsonReadWrite.writeToJSONFile(equations, "te*st.json"));
    }

    @Test
    void myReadFromJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myReadFromJSONFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myReadFromJSONFileNoFound() {
        assertThrows(RuntimeException.class,
                () -> JsonReadWrite.readFromJSONFile("test.json"));
    }

    @Test
    void myReadFromJSONFileInvalidInformation() {
        File fileToCreate = new File("test.json");
        try {
            fileToCreate.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalArgumentException.class,
                () -> JsonReadWrite.readFromJSONFile("test.json"));
    }

    @Test
    void myWriteToJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = readFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myWriteToJSONFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myWriteToJSONFileInvalidPath() {
        List<MathEquation> equations = new ArrayList<>();
        assertThrows(RuntimeException.class,
                () -> JsonReadWrite.writeToJSONFile(equations, "te*st.json"));
    }

    @AfterEach
    void cleanUp() {
        File fileToDelete = new File("test.json");
        fileToDelete.delete();
    }
}