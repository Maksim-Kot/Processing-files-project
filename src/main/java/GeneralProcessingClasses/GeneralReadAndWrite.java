package GeneralProcessingClasses;

import AdditionalClasses.FileTypeAndMethod;
import EquationClass.MathEquation;
import ReadAndWrite.*;

import java.util.ArrayList;
import java.util.List;

public class GeneralReadAndWrite {

    public static List<MathEquation> readFile(String fileName, FileTypeAndMethod fileTypeAndMethod) {
        List<MathEquation> eq = new ArrayList<>();
        try {
            switch (fileTypeAndMethod) {
                case JSON_API:
                    eq = JsonReadWrite.readFromJSONFile(fileName);
                    break;
                case JSON_FUNC:
                    eq = MyJsonReadWrite.myReadFromJSONFile(fileName);
                    break;
                case XML_API:
                    eq = XMLReadWrite.readFromXMLFile(fileName);
                    break;
                case XML_FUNC:
                    eq = MyXMLReadWrite.myReadFromXMLFile(fileName);
                    break;
                case TXT:
                    eq = TXTReadWrite.readFromTXTFile(fileName);
                    break;
                case AUTO:
                    eq = null;
                    break;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

        return eq;
    }
}
