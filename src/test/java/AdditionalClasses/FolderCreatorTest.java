package AdditionalClasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static AdditionalClasses.FolderCreator.createFolder;
import static org.junit.jupiter.api.Assertions.*;

class FolderCreatorTest {

    @BeforeAll
    static void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void createFolderTestNew() {
        String folder = "out";
        assertTrue(createFolder("folderfortesting\\" + folder));
    }

    @Test
    void createFolderTestExist() {
        String folder = "out";
        createFolder("folderfortesting\\" + folder);
        assertTrue(createFolder("folderfortesting\\" + folder));
    }

    @Test
    void createFolderTestInvalidName1() {
        String folder = "ou?t";
        assertFalse(createFolder("folderfortesting\\" + folder));
    }

    @Test
    void createFolderTestInvalidName2() {
        String folder = "ou<t";
        assertFalse(createFolder("folderfortesting\\" + folder));
    }

    @AfterEach
    void deleteTestSubFolder() {
        File file = new File("folderfortesting\\out");
        file.delete();
    }

    @AfterAll
    static void deleteTestFolder() {
        File file = new File("folderfortesting");
        file.delete();
    }
}