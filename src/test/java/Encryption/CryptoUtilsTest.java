package Encryption;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CryptoUtilsTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void encryptAndDecryptTest() {
        String key = "Mike has one cat";
        String content = "Some test text";
        File inputFile = new File("folderfortesting\\document.txt");
        try {
            inputFile.createNewFile();
            try (FileWriter fileWriter = new FileWriter(inputFile)) {
                fileWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File encryptedFile = new File("folderfortesting\\document.encrypted");
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        assertTrue(encryptedFile.exists());
        String res;
        File decryptedFile = new File("folderfortesting\\document.decrypted");
        try {
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        try (FileReader fileReader = new FileReader(decryptedFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            res = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(encryptedFile.exists());
        assertEquals(content, res);
    }

    @Test
    void encryptTestInvalidSizeOfKey() {
        String key = "Mike has one cat1"; // 17 bite
        File inputFile = new File("folderfortesting\\document.txt");
        File encryptedFile = new File("folderfortesting\\document.encrypted");
        assertThrows(CryptoException.class,
                () -> CryptoUtils.encrypt(key, inputFile, encryptedFile));
    }

    @Test
    void decryptTestIncorrectKey() {
        String content = "Some test text";
        String key = "Mike has one cat";
        String incorrectKey = "Nina has one dog";
        File inputFile = new File("folderfortesting\\document.txt");
        try {
            inputFile.createNewFile();
            try (FileWriter fileWriter = new FileWriter(inputFile)) {
                fileWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File encryptedFile = new File("folderfortesting\\document.encrypted");
        File decryptedFile = new File("folderfortesting\\document.decrypted");
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        assertThrows(CryptoException.class,
                () -> CryptoUtils.decrypt(incorrectKey, encryptedFile, decryptedFile));
    }

    @AfterEach
    void deleteTestSubFolder() {
        File inputFile = new File("folderfortesting\\document.txt");
        File encryptedFile = new File("folderfortesting\\document.encrypted");
        File decryptedFile = new File("folderfortesting\\document.decrypted");

        try {
            Thread.sleep(100); // add a small delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inputFile.deleteOnExit();
        encryptedFile.deleteOnExit();
        decryptedFile.deleteOnExit();
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