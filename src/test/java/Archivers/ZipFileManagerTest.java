package Archivers;

import AdditionalClasses.FileModification;
import Encryption.CryptoException;
import Encryption.CryptoUtils;
import GeneralProcessingClasses.GeneralModifier;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ZipFileManagerTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void zipAndUnZIPFilesTest() {
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
            ZipFileManager.zipFiles(nameOfFolder);
            ZipFileManager.unzipFiles(nameOfFolder + ".zip", nameOfOutFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(new File(nameOfFolder + ".zip").exists());
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
        try (FileReader fileReader = new FileReader(nameOfOutFolder + nameOfFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            res = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(content, res);
    }

    @Test
    void zipFilesTestNotFolder() {
        String nameOfFile = "folderfortesting\\out.txt";
        try {
            new File(nameOfFile).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(IOException.class,
                () -> ZipFileManager.zipFiles(nameOfFile));
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