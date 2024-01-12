package AdditionalClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileModificationTest {

    @Test
    void getChoiceTestARCHIVED_RAR() {
        FileModification fileModification = FileModification.ARCHIVED_RAR;
        assertEquals("archived (RAR)", fileModification.getChoice());
    }

    @Test
    void getChoiceTestARCHIVED_ZIP() {
        FileModification fileModification = FileModification.ARCHIVED_ZIP;
        assertEquals("archived (ZIP)", fileModification.getChoice());
    }

    @Test
    void getChoiceTestENCRYPTED() {
        FileModification fileModification = FileModification.ENCRYPTED;
        assertEquals("encrypted", fileModification.getChoice());
    }

    @Test
    void getChoiceTestARCHIVED_ZIP_THEN_ENCRYPTED() {
        FileModification fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;
        assertEquals("archived (ZIP) and then encrypted", fileModification.getChoice());
    }

    @Test
    void getChoiceTestARCHIVED_RAR_THEN_ENCRYPTED() {
        FileModification fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;
        assertEquals("archived (RAR) and then encrypted", fileModification.getChoice());
    }

    @Test
    void getChoiceTestENCRYPTED_THEN_ARCHIVED_ZIP() {
        FileModification fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;
        assertEquals("encrypted and then archived (ZIP)", fileModification.getChoice());
    }

    @Test
    void getChoiceTestENCRYPTED_THEN_ARCHIVED_RAR() {
        FileModification fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;
        assertEquals("encrypted and then archived (RAR)", fileModification.getChoice());
    }

    @Test
    void getChoiceTestNO_MODIFICATION() {
        FileModification fileModification = FileModification.NO_MODIFICATION;
        assertEquals("modified", fileModification.getChoice());
    }
}