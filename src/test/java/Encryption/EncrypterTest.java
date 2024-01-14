package Encryption;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void encryptAndDecryptTest() {
        String key = "Mike has one cat";
        String content = "Some test text";
        String nameOfInputFile = "folderfortesting\\document.txt";
        String nameOfEncryptedFile = "folderfortesting\\document.encrypted";
        String nameOfDecryptedFile = "folderfortesting\\document.decrypted";
        File inputFile = new File(nameOfInputFile);
        try {
            inputFile.createNewFile();
            try (FileWriter fileWriter = new FileWriter(inputFile)) {
                fileWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Encrypter.encrypt(nameOfInputFile, nameOfEncryptedFile, key);
        File encryptedFile = new File(nameOfEncryptedFile);
        assertTrue(encryptedFile.exists());
        Encrypter.decrypt(nameOfEncryptedFile, nameOfDecryptedFile, key);
        String res;
        File decryptedFile = new File(nameOfDecryptedFile);
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
        String nameOfInputFile = "folderfortesting\\document.txt";
        String nameOfEncryptedFile = "folderfortesting\\document.encrypted";
        assertThrows(RuntimeException.class,
                () -> Encrypter.encrypt(nameOfInputFile, nameOfEncryptedFile, key));
    }

    @Test
    void decryptTestIncorrectKey() {
        String key = "Mike has one cat";
        String incorrectKey = "Nina has one dog";
        String nameOfInputFile = "folderfortesting\\document.txt";
        String nameOfEncryptedFile = "folderfortesting\\document.encrypted";
        String nameOfDecryptedFile = "folderfortesting\\document.decrypted";
        File inputFile = new File(nameOfInputFile);
        try {
            inputFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Encrypter.encrypt(nameOfInputFile, nameOfEncryptedFile, key);
        assertThrows(RuntimeException.class,
                () -> Encrypter.decrypt(nameOfEncryptedFile, nameOfDecryptedFile, incorrectKey));
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