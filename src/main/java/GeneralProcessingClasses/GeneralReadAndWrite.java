package GeneralProcessingClasses;

import AdditionalClasses.FileTypeAndMethod;
import EquationClass.MathEquation;
import ReadAndWrite.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
                    {
                        String line;
                        line = br.readLine();
                        if('[' == line.charAt(0)){
                            eq = JsonReadWrite.readFromJSONFile(fileName);
                        } else if (line.startsWith("<?xml version")){
                            eq = XMLReadWrite.readFromXMLFile(fileName);
                        } else {
                            String[] parts = line.split("; ");
                            if (parts.length == 3){
                                eq = TXTReadWrite.readFromTXTFile(fileName);
                            }
                        }
                    } catch (IOException e)
                    {
                        throw new RuntimeException(e.getMessage());
                    }
                    if(eq.isEmpty()) throw new IllegalArgumentException("File auto-detection error");
                    break;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

        return eq;
    }

    public static void writeFile(List<MathEquation> eq, String fileName, FileTypeAndMethod fileTypeAndMethod) {
        try {
            switch (fileTypeAndMethod) {
                case JSON_API:
                    JsonReadWrite.writeToJSONFile(eq, fileName);
                    break;
                case JSON_FUNC:
                    MyJsonReadWrite.myWriteToJSONFile(eq, fileName);
                    break;
                case XML_API:
                    XMLReadWrite.writeToXMLFile(eq, fileName);
                    break;
                case XML_FUNC:
                    MyXMLReadWrite.myWriteToXMLFile(eq, fileName);
                    break;
                case TXT:
                    TXTReadWrite.writeToTXTFile(eq, fileName);
                    break;
                case AUTO:
                    eq = null;
                    break;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
