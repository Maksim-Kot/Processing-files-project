package AdditionalClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTypeAndMethodTest {

    @Test
    void getChoiceTestJSON_API() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.JSON_API;
        assertEquals("JSON file using the API", fileTypeAndMethod.getChoice());
    }

    @Test
    void getChoiceTestJSON_FUNC() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
        assertEquals("JSON file using the function", fileTypeAndMethod.getChoice());
    }

    @Test
    void getChoiceTestXML_API() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.XML_API;
        assertEquals("XML file using the API", fileTypeAndMethod.getChoice());
    }

    @Test
    void getChoiceTestXML_FUNC() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
        assertEquals("XML file using the function", fileTypeAndMethod.getChoice());
    }

    @Test
    void getChoiceTestTXT() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.TXT;
        assertEquals("TXT file", fileTypeAndMethod.getChoice());
    }

    @Test
    void getChoiceTestAUTO() {
        FileTypeAndMethod fileTypeAndMethod = FileTypeAndMethod.AUTO;
        assertEquals("file with auto-type detection", fileTypeAndMethod.getChoice());
    }
}