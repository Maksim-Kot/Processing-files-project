package ReadAndWrite;

import EquationClass.MathEquation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ReadAndWrite.MyXMLReadWrite.myReadFromXMLFile;
import static ReadAndWrite.MyXMLReadWrite.myWriteToXMLFile;
import static ReadAndWrite.XMLReadWrite.readFromXMLFile;
import static ReadAndWrite.XMLReadWrite.writeToXMLFile;
import static org.junit.jupiter.api.Assertions.*;

class AllXMLReadWriteTest {

    @Test
    void readFromXMLFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = readFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void readFromXMLFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = readFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void writeToXMLFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = readFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void writeToXMLFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = myReadFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myReadFromXMLFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = myReadFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myReadFromXMLFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = myReadFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myWriteToXMLFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = readFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myWriteToXMLFile2() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToXMLFile(equations, "test.xml");

        List<MathEquation> equationsget = myReadFromXMLFile("test.xml");

        assertTrue(equationsget.equals(equations));
    }
}