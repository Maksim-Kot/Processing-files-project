package Archivers;

import AdditionalClasses.FileModification;
import GeneralProcessingClasses.GeneralModifier;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ArchiverTest {

    @BeforeEach
    void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void archiveAndDearchiveTestRAR() {
        FileModification fileModification = FileModification.ARCHIVED_RAR;
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
        Archiver.archive(nameOfFolder, fileModification);
        Archiver.dearchive(nameOfFolder + ".rar", nameOfOutFolder, fileModification);
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

    @Test
    void archiveAndDearchiveTestZIP() {
        FileModification fileModification = FileModification.ARCHIVED_ZIP;
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
        Archiver.archive(nameOfFolder, fileModification);
        Archiver.dearchive(nameOfFolder + ".zip", nameOfOutFolder, fileModification);
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
    void archiveTestZipNoFolder() {
        FileModification fileModification = FileModification.ARCHIVED_ZIP;
        String nameOfFile = "folderfortesting\\out.txt";
        try {
            new File(nameOfFile).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(RuntimeException.class,
                () -> Archiver.archive(nameOfFile, fileModification));
    }

    @Test
    void isFolderEmptyTestNoFiles() {
        String nameOfFolder = "folderfortesting\\empty";
        File file = new File(nameOfFolder);
        file.mkdirs();
        assertTrue(GeneralModifier.isFolderEmpty(nameOfFolder));
    }

    @Test
    void isFolderEmptyTestWithFiles() {
        String nameOfFolder = "folderfortesting\\empty";
        String nameOfFile = "folderfortesting\\empty\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertFalse(GeneralModifier.isFolderEmpty(nameOfFolder));
    }

    @Test
    void deleteFolderTest() {
        String nameOfFolder = "folderfortesting\\empty";
        File file = new File(nameOfFolder);
        file.mkdirs();
        GeneralModifier.deleteFolder(nameOfFolder);
        assertTrue(GeneralModifier.isFolderEmpty("folderfortesting"));
    }

    @AfterEach
    void deleteTestFolder() {
        File file = new File("folderfortesting");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}