package GeneralProcessingClasses;

import AdditionalClasses.FileModification;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GeneralModifierTest {

    @BeforeEach
    void addTestFolder() {
        File file = new File("folderfortesting");
        file.mkdirs();
    }

    @Test
    void modifieAndUnmodifieTestARCHIVED_RAR() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ARCHIVED_RAR;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".rar");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".rar").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
    }

    @Test
    void modifieAndUnmodifieTestARCHIVED_ZIP() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ARCHIVED_ZIP;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".zip");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".zip").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
    }

    @Test
    void modifieAndUnmodifieTestENCRYPTED() {
        String nameOfFile = "folderfortesting\\input.txt";
        String nameOfOutFile = "folderfortesting\\output";
        File file = new File(nameOfFile);
        try {
            new File(nameOfOutFile).mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ENCRYPTED;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFile);
        modifierBuilder.setKey("nothing to do-do");
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFile + ".enc");
        unmodifierBuilder.setDirectoryName(nameOfOutFile);
        unmodifierBuilder.setKey("nothing to do-do");
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFile + ".enc").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFile).exists());
    }

    @Test
    void modifieAndUnmodifieTestENCRYPTED_THEN_ARCHIVED_RAR() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setKey("nothing to do-do");
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".rar");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setKey("nothing to do-do");
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".rar").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
        assertTrue(new File(nameOfOutFolder + nameOfFile + ".enc").exists());
    }

    @Test
    void modifieAndUnmodifieTestENCRYPTED_THEN_ARCHIVED_ZIP() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setKey("nothing to do-do");
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".zip");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setKey("nothing to do-do");
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".zip").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
        assertTrue(new File(nameOfOutFolder + nameOfFile + ".enc").exists());
    }

    @Test
    void modifieAndUnmodifieTestARCHIVED_RAR_THEN_ENCRYPTED() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setKey("nothing to do-do");
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".rar.enc");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setKey("nothing to do-do");
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".rar.enc").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
    }

    @Test
    void modifieAndUnmodifieTestARCHIVED_ZIP_THEN_ENCRYPTED() {
        String nameOfFolder = "folderfortesting\\good";
        String nameOfOutFolder = "folderfortesting\\out";
        String nameOfFile = "\\input.txt";
        File folder = new File(nameOfFolder);
        File file = new File(nameOfFolder + nameOfFile);
        folder.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileModification fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;

        GeneralModifierBuilderImpl modifierBuilder = new GeneralModifierBuilderImpl();
        modifierBuilder.setDirectoryName(nameOfFolder);
        modifierBuilder.setKey("nothing to do-do");
        modifierBuilder.setFileModification(fileModification);

        GeneralModifierBuilderImpl unmodifierBuilder = new GeneralModifierBuilderImpl();
        unmodifierBuilder.setNameOfArchive(nameOfFolder + ".zip.enc");
        unmodifierBuilder.setDirectoryName(nameOfOutFolder);
        unmodifierBuilder.setKey("nothing to do-do");
        unmodifierBuilder.setFileModification(fileModification);

        GeneralModifier generalMod = modifierBuilder.build();
        generalMod.modifie();
        assertTrue(new File(nameOfFolder + ".zip.enc").exists());

        GeneralModifier generalUnmod = unmodifierBuilder.build();
        generalUnmod.unmodifie();
        assertTrue(new File(nameOfOutFolder + nameOfFile).exists());
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