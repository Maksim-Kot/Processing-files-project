package ReadAndWrite;

import EquationClass.MathEquation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ReadAndWrite.TXTReadWrite.readFromTXTFile;
import static ReadAndWrite.TXTReadWrite.writeToTXTFile;
import static org.junit.jupiter.api.Assertions.*;

class TXTReadWriteTest {

    @Test
    void readFromTXTFileTest() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"))) {
            bw.write("x + y = 10; x, y; 7.9");
            bw.newLine();
            bw.write("2 * z = 16; z; 8");
            bw.newLine();
            bw.write("x + y = 10; x, y; 7");
            bw.newLine();
            bw.write("2 * a = 8; a; 4");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MathEquation> equationsget = readFromTXTFile("test.txt");

        assertTrue(equationsget.equals(equations));
    }

    @Test
    void readFromTXTFileTestNoFound() {
        assertThrows(RuntimeException.class,
                () -> TXTReadWrite.readFromTXTFile("test.txt"));
    }

    @Test
    void readFromTXTFileTestInvalidInformation() {
        File fileToCreate = new File("test.txt");
        try {
            fileToCreate.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalArgumentException.class,
                () -> TXTReadWrite.readFromTXTFile("test.txt"));
    }

    @Test
    void writeToTXTFileTest() {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7.9));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        writeToTXTFile(equations, "test.txt");

        String result = "";

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                result += line +"\n";
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        String needed = "x + y = 10; x, y; 7.9\n2 * z = 16; z; 8.0\nx + y = 10; x, y; 7.0\n2 * a = 8; a; 4.0\n";

        assertTrue(needed.equals(result));
    }

    @Test
    void writeToTXTFileInvalidPath() {
        List<MathEquation> equations = new ArrayList<>();
        assertThrows(RuntimeException.class,
                () -> TXTReadWrite.writeToTXTFile(equations, "te*st.txt"));
    }

    @AfterEach
    void cleanUp() {
        File fileToDelete = new File("test.txt");
        fileToDelete.delete();
    }
}