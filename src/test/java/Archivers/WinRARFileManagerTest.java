package Archivers;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WinRARFileManagerTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void createAndExtractRAR() {
        String content = "hello world";
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        String res;
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            WinRARFileManager.createRAR(nameOfFolder, "D:\\Other project\\Java\\end-to-end_project\\"+nameOfFolder+".rar");
            WinRARFileManager.extractRAR(nameOfFolder + ".rar", nameOfOutFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(new File(nameOfFolder + ".rar").exists());
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
        try (FileReader fileReader = new FileReader(nameOfOutFolder + nameOfFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            res = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(content, res);
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