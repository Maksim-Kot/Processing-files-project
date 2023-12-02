package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.JsonReadWrite.readFromJSONFile;
import static org.example.JsonReadWrite.writeToJSONFile;
import static org.example.MyJsonReadWrite.myReadFromJSONFile;
import static org.example.MyJsonReadWrite.myWriteToJSONFile;
import static org.junit.jupiter.api.Assertions.*;

class AllJsonReadWriteTest {

    @Test
    void readFromJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
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
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = readFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void writeToJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
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
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myReadFromJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
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
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void myWriteToJSONFile1() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
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
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "test.json");

        List<MathEquation> equationsget = myReadFromJSONFile("test.json");

        assertTrue(equationsget.equals(equations));
    }
}