package org.example;

import AdditionalClasses.*;
import EquationClass.MathEquation;
import GeneralProcessingClasses.GeneralCalculation;
import GeneralProcessingClasses.GeneralModifier;
import GeneralProcessingClasses.GeneralModifierBuilderImpl;
import GeneralProcessingClasses.GeneralReadAndWrite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainGUIController implements Initializable {
    GeneralModifier generalModifier = null;
    GeneralModifierBuilderImpl modifierBuilder = null;

    FileModification fileModification = null;
    FileTypeAndMethod fileTypeAndMethod = null;
    MethodToCalculate methodToCalculate = null;

    List<MathEquation> eq = null;
    List<MathEquation> calculatedEq = null;

    String archiverName = null;
    String outputFolderForArchiver = "output";
    String fileName = null;

    String folderPath = "";
    String[] extensions = null;
    List<String> matchingFiles = new ArrayList<>();

    String nameOfFolderToSave = "";
    String nameOfFileToSave = "";
    String nameOfArchiveToSave = "";

    String key = "Mary has one cat";

    @FXML
    private TextArea outArea;


    @FXML
    private ChoiceBox<String> unmod;
    @FXML
    private ChoiceBox<String> unmodFile;
    @FXML
    private TextField unmodFolder;
    @FXML
    private Button unmodButton;


    @FXML
    private ChoiceBox<String> procTypeReading;
    @FXML
    private ChoiceBox<String> procTypeCalc;
    @FXML
    private ChoiceBox<String> procTypeWriting;
    @FXML
    private ChoiceBox<String> procFileToCalc;
    @FXML
    private TextField procNameOfFolder;
    @FXML
    private TextField procFolderToSave;
    @FXML
    private TextField procNameOfFile;
    @FXML
    private Button procButton;
    @FXML
    private Button folderButton;
    @FXML
    private Button calcButton;


    private String[] unmodification = {"The file has been archived (ZIP)",
            "The file has been archived (RAR)",
            "The file has been encrypted",
            "The file was encrypted and then archived (ZIP)",
            "The file was encrypted and then archived (RAR)",
            "The file was archived (ZIP) and then encrypted",
            "The file was archived (RAR) and then encrypted"};

    private String[] procCalc = {"Calculate via API",
            "Calculate via function",
            "Calculate via regex (parsing)"};
    private String[] procReading = {"Read JSON file using the API",
            "Read JSON file using the function",
            "Read XML file using the API",
            "Read XML file using the function",
            "Read TXT file",
            "Read file with auto-type detection"};
    private String[] procWriting = {"Write JSON file using the API",
            "Write JSON file using the function",
            "Write XML file using the API",
            "Write XML file using the function",
            "Write TXT file"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unmod.getItems().addAll(unmodification);
        procTypeReading.getItems().addAll(procReading);
        procTypeCalc.getItems().addAll(procCalc);
        procTypeWriting.getItems().addAll(procWriting);
        unmod.setOnAction(this::setFilesUnMod);
        outArea.setText("This program will help you:\n" +
                "- perform operations on files;\n" +
                "- calculate the values of expressions written in files;\n" +
                "- save the result in a format convenient for you.");
    }

    private void setFilesUnMod(ActionEvent actionEvent) {
        outArea.clear();
        String input = unmod.getValue();
        switch (input) {
            case "The file has been archived (ZIP)":
                fileModification = FileModification.ARCHIVED_ZIP;
                break;
            case "The file has been archived (RAR)":
                fileModification = FileModification.ARCHIVED_RAR;
                break;
            case "The file has been encrypted":
                fileModification = FileModification.ENCRYPTED;
                break;
            case "The file was encrypted and then archived (ZIP)":
                fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;
                break;
            case "The file was encrypted and then archived (RAR)":
                fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;
                break;
            case "The file was archived (ZIP) and then encrypted":
                fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;
                break;
            case "The file was archived (RAR) and then encrypted":
                fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;
                break;
        }

        switch (fileModification) {
            case ARCHIVED_RAR, ARCHIVED_ZIP, ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP:
                folderPath = "files";
                extensions = new String[]{".rar", ".zip"};
                matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

                if (!matchingFiles.isEmpty())
                {
                    unmodFile.getItems().clear();
                    unmodFile.getItems().addAll(matchingFiles);
                } else {
                    unmodFile.getItems().clear();
                    outArea.setText("There are no files with the specified extensions in the specified folder");
                }
                break;
            case ENCRYPTED, ARCHIVED_RAR_THEN_ENCRYPTED, ARCHIVED_ZIP_THEN_ENCRYPTED:
                folderPath = "files";
                extensions = new String[]{".enc"};
                matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

                if (!matchingFiles.isEmpty())
                {
                    unmodFile.getItems().clear();
                    unmodFile.getItems().addAll(matchingFiles);
                } else {
                    unmodFile.getItems().clear();
                    outArea.setText("There are no files with the specified extensions in the specified folder");
                }
                break;
        }

    }

    public void unmodButtonClick(ActionEvent actionEvent) {
        if(null != unmodFile.getValue() && !unmodFolder.getText().isEmpty()) {
            archiverName = unmodFile.getValue();
            outputFolderForArchiver = unmodFolder.getText();

            archiverName = "files\\" + archiverName;
            outputFolderForArchiver = "files\\" + outputFolderForArchiver;

            // Unmodified file
            switch (fileModification) {
                case ARCHIVED_RAR, ARCHIVED_ZIP:
                    modifierBuilder = new GeneralModifierBuilderImpl();
                    modifierBuilder.setNameOfArchive(archiverName);
                    modifierBuilder.setDirectoryName(outputFolderForArchiver);
                    modifierBuilder.setFileModification(fileModification);
                    generalModifier = modifierBuilder.build();
                    break;
                case ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP,
                        ENCRYPTED, ARCHIVED_RAR_THEN_ENCRYPTED, ARCHIVED_ZIP_THEN_ENCRYPTED:
                    modifierBuilder = new GeneralModifierBuilderImpl();
                    modifierBuilder.setNameOfArchive(archiverName);
                    modifierBuilder.setDirectoryName(outputFolderForArchiver);
                    modifierBuilder.setKey(key);
                    modifierBuilder.setFileModification(fileModification);
                    generalModifier = modifierBuilder.build();
                    break;
            }
            try{
                generalModifier.unmodifie();
                outArea.setText("Files were unmodified successfully");
            }catch (RuntimeException e){
                outArea.setText("Problems with file unmodifying:\n" + e.getMessage());
            }
        } else {
            outArea.setText("Choose all fields");
        }

    }

    public void folderButtonClick(ActionEvent actionEvent) {
        outArea.clear();
        String inputFolder = procNameOfFolder.getText();
        if(!inputFolder.equals("files")){
            inputFolder = "files\\" + inputFolder;
        }

        folderPath = inputFolder;

        extensions = new String[]{".txt", ".xml", ".json"};
        matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

        if (!matchingFiles.isEmpty())
        {
            procFileToCalc.getItems().clear();
            procFileToCalc.getItems().addAll(matchingFiles);
        } else {
            procFileToCalc.getItems().clear();
            outArea.setText("There are no files with the specified extensions in the specified folder");
        }
    }


    public void calcButtonClick(ActionEvent actionEvent) {
        outArea.clear();
        if(null != procFileToCalc.getValue() && null != procTypeReading.getValue()
                && null != procTypeCalc.getValue()){
            String input = procTypeReading.getValue();
            switch (input) {
                case "Read JSON file using the API":
                    fileTypeAndMethod = FileTypeAndMethod.JSON_API;
                    break;
                case "Read JSON file using the function":
                    fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
                    break;
                case "Read XML file using the API":
                    fileTypeAndMethod = FileTypeAndMethod.XML_API;
                    break;
                case "Read XML file using the function":
                    fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
                    break;
                case "Read TXT file":
                    fileTypeAndMethod = FileTypeAndMethod.TXT;
                    break;
                case "Read file with auto-type detection":
                    fileTypeAndMethod = FileTypeAndMethod.AUTO;
                    break;
            }

            String inputCalc = procTypeCalc.getValue();
            switch (inputCalc) {
                case "Calculate via API":
                    methodToCalculate = MethodToCalculate.API;
                    break;
                case "Calculate via function":
                    methodToCalculate = MethodToCalculate.FUNC;
                    break;
                case "Calculate via regex (parsing)":
                    methodToCalculate = MethodToCalculate.REGEX;
                    break;
            }

            fileName = folderPath + "\\" + procFileToCalc.getValue();

            try {
                eq = GeneralReadAndWrite.readFile(fileName, fileTypeAndMethod);
            } catch (IllegalArgumentException e) {
                outArea.setText(e.getMessage() + "\n");
            } catch (RuntimeException e) {
                outArea.setText(e.getMessage() + "\n");
            }
            if(null == eq) {
                outArea.appendText("Problems with file");
                fileName = null;
                fileTypeAndMethod = null;
            }
            else {
                outArea.setText("The file was read successfully\n" + eq);

                GeneralCalculation generalCalculation = new GeneralCalculation();
                calculatedEq = generalCalculation.calculate(eq, methodToCalculate);
                if(generalCalculation.isHaveMistakes()){
                    for(String message: generalCalculation.getMistakes()){
                        outArea.appendText("\n" + message);
                    }
                    outArea.appendText("\n" + calculatedEq);
                } else {
                    outArea.appendText("\nThe file was processed successfully\n" + calculatedEq);
                }
            }
        } else {
            outArea.setText("Choose all fields");
        }
    }

    public void procButtonClick(ActionEvent actionEvent) {
        outArea.clear();
        boolean isOK = false;
        if(!procNameOfFile.getText().isEmpty()){
            try{
                Paths.get(nameOfFileToSave);
                isOK = true;
            } catch (RuntimeException e){
                outArea.setText("Invalid name\n" + e.getMessage());
            }
        }
        if(isOK && !procFolderToSave.getText().isEmpty() && null != procTypeWriting.getValue()){
            nameOfFolderToSave = "files\\" + procFolderToSave.getText();
            if(FolderCreator.createFolder(nameOfFolderToSave)){
                nameOfFileToSave = procNameOfFile.getText();
                nameOfFileToSave = nameOfFolderToSave + "\\" + nameOfFileToSave;
                String input = procTypeWriting.getValue();
                switch (input) {
                    case "Write JSON file using the API":
                        fileTypeAndMethod = FileTypeAndMethod.JSON_API;
                        break;
                    case "Write JSON file using the function":
                        fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
                        break;
                    case "Write XML file using the API":
                        fileTypeAndMethod = FileTypeAndMethod.XML_API;
                        break;
                    case "Write XML file using the function":
                        fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
                        break;
                    case "Write TXT file":
                        fileTypeAndMethod = FileTypeAndMethod.TXT;
                        break;
                }

                // Writing file
                try {
                    GeneralReadAndWrite.writeFile(calculatedEq, nameOfFileToSave, fileTypeAndMethod);
                    outArea.setText("The file was written successfully");
                } catch (RuntimeException e) {
                    outArea.setText(e.getMessage());
                }
            } else {
                outArea.setText("Problems with folder. Try again");
            }
        } else {
            outArea.appendText("Choose all fields");
        }
    }
}
