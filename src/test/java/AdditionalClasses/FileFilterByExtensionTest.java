package AdditionalClasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static AdditionalClasses.FileFilterByExtension.getFilesByExtensions;
import static org.junit.jupiter.api.Assertions.*;

class FileFilterByExtensionTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
        File file1 = new File("folderfortesting\\input.txt");
        File file2 = new File("folderfortesting\\input.json");
        File file3 = new File("folderfortesting\\input.xml");
        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getFilesByExtensionsTest1() {
        List<String> res = getFilesByExtensions("folderfortesting", ".txt", ".json");
        assertTrue(2 == res.size());
        List<String> needeed = List.of(new String[]{"input.json", "input.txt"});
        assertEquals(needeed, res);
    }

    @Test
    void getFilesByExtensionsTest2() {
        List<String> res = getFilesByExtensions("folderfortesting", ".xml");
        assertTrue(1 == res.size());
        List<String> needeed = List.of(new String[]{"input.xml"});
        assertEquals(needeed, res);
    }

    @Test
    void getFilesByExtensionsTestNoFiles() {
        List<String> res = getFilesByExtensions("folderfortesting", ".enc");
        assertTrue(res.isEmpty());
    }

    @AfterAll
    static void deleteTestFolder() {
        File file = new File("folderfortesting");
        File file1 = new File("folderfortesting\\input.txt");
        File file2 = new File("folderfortesting\\input.json");
        File file3 = new File("folderfortesting\\input.xml");
        file1.delete(); file2.delete(); file3.delete();
        file.delete();

    }
}