package GeneralProcessingClasses;

import AdditionalClasses.FileTypeAndMethod;
import EquationClass.MathEquation;
import ReadAndWrite.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralReadAndWriteTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void writeAndReadFileTestJSON_API() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.JSON_API;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        GeneralReadAndWrite.writeFile(eq, nameOfFile, fileTypeAndMethod);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestJSON_FUNC() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        GeneralReadAndWrite.writeFile(eq, nameOfFile, fileTypeAndMethod);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestXML_API() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.XML_API;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        GeneralReadAndWrite.writeFile(eq, nameOfFile, fileTypeAndMethod);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestXML_FUNC() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        GeneralReadAndWrite.writeFile(eq, nameOfFile, fileTypeAndMethod);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestTXT() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.TXT;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        GeneralReadAndWrite.writeFile(eq, nameOfFile, fileTypeAndMethod);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_JSON() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        JsonReadWrite.writeToJSONFile(eq, nameOfFile);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_MY_JSON() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        MyJsonReadWrite.myWriteToJSONFile(eq, nameOfFile);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_XML() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        XMLReadWrite.writeToXMLFile(eq, nameOfFile);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_MY_XML() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        MyXMLReadWrite.myWriteToXMLFile(eq, nameOfFile);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_TXT() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        List<MathEquation> eq = new ArrayList<>();
        eq.add(new MathEquation("( ( 0 - 1.0 + x ) * ( y + (- 4) ) / x + ( .7 - 0.8 ) ) / x", "x = 2, y = 5.78", 0.0));
        eq.add(new MathEquation("8-a+    7.8*b", "a = 9, b = -4", 0.0));
        eq.add(new MathEquation("((1+x)*(5-4)/x   +(1-x))/x", "x = 2, y", 0.0));
        eq.add(new MathEquation("2     * a", "a = 4", 0.0));
        TXTReadWrite.writeToTXTFile(eq, nameOfFile);
        List<MathEquation> res = GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod);
        assertEquals(res, eq);
    }

    @Test
    void writeAndReadFileTestAUTO_ERROR() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        String nameOfFile = "folderfortesting\\input.json";
        String content = "hello world";
        File file = new File(nameOfFile);
        try {
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalArgumentException.class,
                () -> GeneralReadAndWrite.readFile(nameOfFile, fileTypeAndMethod));
    }

    @AfterEach
    void deleteTestFiles() {
        new File("folderfortesting\\input.json").delete();
        new File("folderfortesting\\input.xml").delete();
        new File("folderfortesting\\input.txt").delete();
    }

    @AfterAll
    static void deleteTestFolder() {
        File file = new File("folderfortesting");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}