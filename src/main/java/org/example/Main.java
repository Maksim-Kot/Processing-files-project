package org.example;

import AdditionalClasses.*;
import GeneralProcessingClasses.GeneralModifier;
import EquationClass.MathEquation;
import GeneralProcessingClasses.GeneralCalculation;
import GeneralProcessingClasses.GeneralModifierBuilderImpl;
import GeneralProcessingClasses.GeneralReadAndWrite;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("This program will help you:\n" +
                "- perform operations on files;\n" +
                "- calculate the values of expressions written in files;\n" +
                "- save the result in a format convenient for you.\n" +
                "To start press 'Enter'");

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            } else {
                System.out.println("You enter: " + input);
                System.out.println("Please, press 'Enter' to continue");
            }
        }

        /*
        BLOCK OF UNMODIFICATION
         */
        while (true){
            System.out.println("Select what modifications were made to the file(s) (enter the number):\n" +
                    "1) The file has been archived (ZIP)\n" +
                    "2) The file has been archived (RAR)\n" +
                    "3) The file has been encrypted\n" +
                    "4) The file was encrypted and then archived (ZIP)\n" +
                    "5) The file was encrypted and then archived (RAR)\n" +
                    "6) The file was archived (ZIP) and then encrypted\n" +
                    "7) The file was archived (RAR) and then encrypted\n" +
                    "8) The file has not been modified");
            System.out.print(">");

            while (null == fileModification) {
                String input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            fileModification = FileModification.ARCHIVED_ZIP;
                            System.out.println("You choosed: The file has been " + fileModification.getChoice());
                            break;
                        case 2:
                            fileModification = FileModification.ARCHIVED_RAR;
                            System.out.println("You choosed: The file has been " + fileModification.getChoice());
                            break;
                        case 3:
                            fileModification = FileModification.ENCRYPTED;
                            System.out.println("You choosed: The file has been " + fileModification.getChoice());
                            break;
                        case 4:
                            fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;
                            System.out.println("You choosed: The file was " + fileModification.getChoice());
                            break;
                        case 5:
                            fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;
                            System.out.println("You choosed: The file was " + fileModification.getChoice());
                            break;
                        case 6:
                            fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;
                            System.out.println("You choosed: The file was " + fileModification.getChoice());
                            break;
                        case 7:
                            fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;
                            System.out.println("You choosed: The file was " + fileModification.getChoice());
                            break;
                        case 8:
                            fileModification = FileModification.NO_MODIFICATION;
                            System.out.println("You choosed: The file has not been " + fileModification.getChoice());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            switch (fileModification) {
                case ARCHIVED_RAR, ARCHIVED_ZIP, ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP:
                    folderPath = "files";
                    extensions = new String[]{".rar", ".zip"};
                    matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

                    if (!matchingFiles.isEmpty())
                    {
                        System.out.println("Select the name of the file that needs to be modified (enter the number):");
                        for (int i = 0; i < matchingFiles.size(); ++i)
                        {
                            System.out.println(i+1 + ") " + matchingFiles.get(i));
                        }
                        System.out.print(">");
                    } else
                    {
                        System.out.println("There are no files with the specified extensions in the specified folder");
                        break;
                    }

                    while (null == archiverName) {
                        String input = scanner.nextLine();
                        try {
                            int chose = Integer.parseInt(input);
                            if(chose > 0 && chose <= matchingFiles.size()) {
                                archiverName = matchingFiles.get(chose-1);
                                System.out.println("You choosed: " + archiverName);
                            }
                            else throw new IllegalStateException("Unexpected value: " + chose);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again. Enter the number:");
                            System.out.print(">");
                        } catch (NumberFormatException e) {
                            System.out.println("This is not a number.\n" +
                                    "Try again. Enter the number:");
                            System.out.print(">");
                        }
                    }

                    matchingFiles.clear(); // Refresh list

                    System.out.println("\n"); // For space

                    System.out.println("Enter the name of the directory where you would like to save file(s):");
                    System.out.print(">");
                    outputFolderForArchiver = scanner.nextLine();
                    while (!FolderCreator.createFolder("files\\" + outputFolderForArchiver)){
                        System.out.println("The directory has not been created. Try again");
                        System.out.println("Enter the name of the directory where you would like to save file(s):");
                        System.out.print(">");
                        outputFolderForArchiver = scanner.nextLine();
                    }
                    System.out.println("The directory was successfully created");


                    System.out.println("\n"); // For space


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
                        case ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP:
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
                        System.out.println("Files were unmodified successfully");
                    }catch (RuntimeException e){
                        System.out.println("Problems with file unmodifying:");
                        System.out.println(e.getMessage());
                        return;
                    }
                    break;
                case ENCRYPTED, ARCHIVED_RAR_THEN_ENCRYPTED, ARCHIVED_ZIP_THEN_ENCRYPTED:
                    folderPath = "files";
                    extensions = new String[]{".enc"};
                    matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

                    if (!matchingFiles.isEmpty())
                    {
                        System.out.println("Select the name of the file that needs to be modified (enter the number):");
                        for (int i = 0; i < matchingFiles.size(); ++i)
                        {
                            System.out.println(i+1 + ") " + matchingFiles.get(i));
                        }
                        System.out.print(">");
                    } else
                    {
                        System.out.println("There are no files with the specified extensions in the specified folder");
                        break;
                    }

                    while (null == archiverName) {
                        String input = scanner.nextLine();
                        try {
                            int chose = Integer.parseInt(input);
                            if(chose > 0 && chose <= matchingFiles.size()) {
                                archiverName = matchingFiles.get(chose-1);
                                System.out.println("You choosed: " + archiverName);
                            }
                            else throw new IllegalStateException("Unexpected value: " + chose);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again. Enter the number:");
                            System.out.print(">");
                        } catch (NumberFormatException e) {
                            System.out.println("This is not a number.\n" +
                                    "Try again. Enter the number:");
                            System.out.print(">");
                        }
                    }

                    matchingFiles.clear(); // Refresh list

                    System.out.println("\n"); // For space


                    System.out.println("Enter the name of the directory where you would like to save file(s):");
                    System.out.print(">");
                    outputFolderForArchiver = scanner.nextLine();
                    while (!FolderCreator.createFolder("files\\" + outputFolderForArchiver)){
                        System.out.println("The directory has not been created. Try again");
                        System.out.println("Enter the name of the directory where you would like to save file(s):");
                        System.out.print(">");
                        outputFolderForArchiver = scanner.nextLine();
                    }
                    System.out.println("The directory was successfully created");


                    System.out.println("\n"); // For space


                    archiverName = "files\\" + archiverName;
                    outputFolderForArchiver = "files\\" + outputFolderForArchiver;


                    // Unmodified file
                    modifierBuilder = new GeneralModifierBuilderImpl();
                    modifierBuilder.setNameOfArchive(archiverName);
                    modifierBuilder.setDirectoryName(outputFolderForArchiver);
                    modifierBuilder.setKey(key);
                    modifierBuilder.setFileModification(fileModification);
                    generalModifier = modifierBuilder.build();

                    try{
                        generalModifier.unmodifie();
                        System.out.println("Files were unmodified successfully");
                    }catch (RuntimeException e){
                        System.out.println("Problems with file unmodifying:");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case NO_MODIFICATION:
                    outputFolderForArchiver = "files";
                    break;
            }

            System.out.println("Select next action (enter the number):\n" +
                    "1) Go to next step\n" +
                    "2) Unmodify one more file\n" +
                    "3) Close program");
            System.out.print(">");

            String input;
            while (true) {
                input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            System.out.println("You choosed: Go to next step");
                            break;
                        case 2:
                            System.out.println("You choosed: Unmodify one more file");
                            break;
                        case 3:
                            System.out.println("You choosed: Close program");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                }
                break;
            }

            switch (Integer.parseInt(input)) {
                case 1:
                    fileModification = null;
                    archiverName = null;
                    generalModifier = null;
                    modifierBuilder = null;
                    break;
                case 2:
                    fileModification = null;
                    archiverName = null;
                    generalModifier = null;
                    modifierBuilder = null;
                    continue;
                case 3:
                    return;
            }
            break;
        }
        System.out.println("\n"); // For space


        /*
        BLOCK FOR READING, CALCULATION AND WRITING FILES
         */
        while (true){
            System.out.println("Do you want to continue working with this folder: " +
                    outputFolderForArchiver + "?\n" +
                    "If yes, press 'Enter', otherwise enter the folder name:");

            while (true) {
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    folderPath = outputFolderForArchiver;
                    break;
                } else {
                    folderPath = "files\\" + input;
                    break;
                }
            }

            extensions = new String[]{".txt", ".xml", ".json"};
            matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

            if (!matchingFiles.isEmpty())
            {
                System.out.println("Select the file name you want process (enter the number):");
                for (int i = 0; i < matchingFiles.size(); ++i)
                {
                    System.out.println(i+1 + ") " + matchingFiles.get(i));
                }
                System.out.print(">");
            } else
            {
                System.out.println("There are no files with the specified extensions in the specified folder");
                continue;
            }

            while (null == fileName) {
                String input = scanner.nextLine();
                try {
                    int chose = Integer.parseInt(input);
                    if(chose > 0 && chose <= matchingFiles.size()) {
                        fileName = folderPath + "\\" + matchingFiles.get(chose-1);
                        System.out.println("You choosed: " + matchingFiles.get(chose-1));
                    }
                    else throw new IllegalStateException("Unexpected value: " + chose);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            System.out.println("\n"); // For space


            System.out.println("Select the type and method of reading the file (enter the number):\n" +
                    "1) Read JSON file using the API\n" +
                    "2) Read JSON file using the function\n" +
                    "3) Read XML file using the API\n" +
                    "4) Read XML file using the function\n" +
                    "5) Read TXT file\n" +
                    "6) Read file with auto-type detection");
            System.out.print(">");


            while (null == fileTypeAndMethod) {
                String input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            fileTypeAndMethod = FileTypeAndMethod.JSON_API;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        case 2:
                            fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        case 3:
                            fileTypeAndMethod = FileTypeAndMethod.XML_API;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        case 4:
                            fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        case 5:
                            fileTypeAndMethod = FileTypeAndMethod.TXT;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        case 6:
                            fileTypeAndMethod = FileTypeAndMethod.AUTO;
                            System.out.println("You choosed: Read " + fileTypeAndMethod.getChoice());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            System.out.println("\n"); // For space

            // Reading file
            try {
                eq = GeneralReadAndWrite.readFile(fileName, fileTypeAndMethod);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            if(null == eq) {
                System.out.println("Problems with file");
                fileName = null;
                fileTypeAndMethod = null;
                continue;
            }
            else {
                System.out.println("The file was read successfully");
                System.out.println(eq);
            }


            System.out.println("\n"); // For space


            System.out.println("Select a method for counting expressions (enter the number):\n" +
                    "1) Calculate via API\n" +
                    "2) Calculate via function\n" +
                    "3) Calculate via regex (parsing)");
            System.out.print(">");

            while (null == methodToCalculate) {
                String input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            methodToCalculate = MethodToCalculate.API;
                            System.out.println("You choosed: " + methodToCalculate.getChoice());
                            break;
                        case 2:
                            methodToCalculate = MethodToCalculate.FUNC;
                            System.out.println("You choosed: " + methodToCalculate.getChoice());
                            break;
                        case 3:
                            methodToCalculate = MethodToCalculate.REGEX;
                            System.out.println("You choosed: " + methodToCalculate.getChoice());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            System.out.println(); // For space


            GeneralCalculation generalCalculation = new GeneralCalculation();
            calculatedEq = generalCalculation.calculate(eq, methodToCalculate);
            if(generalCalculation.isHaveMistakes()){
                for(String message: generalCalculation.getMistakes()){
                    System.out.println(message);
                }
            } else {
                System.out.println("The file was processed successfully");
            }

            // Refresh for future file recording
            fileTypeAndMethod = null;

            System.out.println("\n"); // For space


            System.out.println("Enter the name of the directory where you would like to save the file:");
            System.out.print(">");
            nameOfFolderToSave = scanner.nextLine();
            nameOfFolderToSave = "files\\" + nameOfFolderToSave;
            while (!FolderCreator.createFolder(nameOfFolderToSave)){
                System.out.println("The directory has not been created. Try again");
                System.out.println("Enter the name of the directory where you would like to save the file:");
                System.out.print(">");
                nameOfFolderToSave = scanner.nextLine();
                nameOfFolderToSave = "files\\" + nameOfFolderToSave;
            }
            System.out.println("The directory was successfully created");


            System.out.println("\n"); // For space


            System.out.println("Select the type and method of writing the file (enter the number):\n" +
                    "1) Write JSON file using the API\n" +
                    "2) Write JSON file using the function\n" +
                    "3) Write XML file using the API\n" +
                    "4) Write XML file using the function\n" +
                    "5) Write TXT file");
            System.out.print(">");


            while (null == fileTypeAndMethod) {
                String input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            fileTypeAndMethod = FileTypeAndMethod.JSON_API;
                            System.out.println("You choosed: Write " + fileTypeAndMethod.getChoice());
                            break;
                        case 2:
                            fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
                            System.out.println("You choosed: Write " + fileTypeAndMethod.getChoice());
                            break;
                        case 3:
                            fileTypeAndMethod = FileTypeAndMethod.XML_API;
                            System.out.println("You choosed: Write " + fileTypeAndMethod.getChoice());
                            break;
                        case 4:
                            fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
                            System.out.println("You choosed: Write " + fileTypeAndMethod.getChoice());
                            break;
                        case 5:
                            fileTypeAndMethod = FileTypeAndMethod.TXT;
                            System.out.println("You choosed: Write " + fileTypeAndMethod.getChoice());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            System.out.println("\n"); // For space


            System.out.println("Enter the name of the file:");
            System.out.print(">");
            nameOfFileToSave = scanner.nextLine();
            while (true){
                try{
                    Paths.get(nameOfFileToSave);
                    break;
                } catch (RuntimeException e){
                    System.out.println("Invalid name");
                    System.out.println(e.getMessage());
                    System.out.println("Try again");
                }
                System.out.println("Enter the name of the file:");
                System.out.print(">");
                nameOfFileToSave = scanner.nextLine();
            }

            nameOfFileToSave = nameOfFolderToSave + "\\" + nameOfFileToSave;


            System.out.println("\n"); // For space


            // Writing file
            try {
                GeneralReadAndWrite.writeFile(calculatedEq, nameOfFileToSave, fileTypeAndMethod);
                System.out.println("The file was written successfully");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\n"); // For space

            System.out.println("Select next action (enter the number):\n" +
                    "1) Go to next step\n" +
                    "2) Process one more file\n" +
                    "3) Close program");
            System.out.print(">");

            String input;
            while (true) {
                input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            System.out.println("You choosed: Go to next step");
                            break;
                        case 2:
                            System.out.println("You choosed: Unmodify one more file");
                            break;
                        case 3:
                            System.out.println("You choosed: Close program");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                }
                break;
            }

            switch (Integer.parseInt(input)) {
                case 1:
                    fileName = null;
                    fileTypeAndMethod= null;
                    methodToCalculate = null;
                    break;
                case 2:
                    fileName = null;
                    fileTypeAndMethod= null;
                    methodToCalculate = null;
                    continue;
                case 3:
                    return;
            }
            break;
        }
        System.out.println("\n");


        /*
        BLOCK OF MODIFYING FILES
         */
        while (true) {
            System.out.println("Select modifications to be made to the file(s) (enter the number):\n" +
                    "1) The file need to be archived (ZIP)\n" +
                    "2) The file need to be archived (RAR)\n" +
                    "3) The file need to be encrypted\n" +
                    "4) The file need to be encrypted and then archived (ZIP)\n" +
                    "5) The file need to be encrypted and then archived (RAR)\n" +
                    "6) The file need to be archived (ZIP) and then encrypted\n" +
                    "7) The file need to be archived (RAR) and then encrypted\n" +
                    "8) No modified");
            System.out.print(">");

            while (null == fileModification) {
                String input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            fileModification = FileModification.ARCHIVED_ZIP;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 2:
                            fileModification = FileModification.ARCHIVED_RAR;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 3:
                            fileModification = FileModification.ENCRYPTED;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 4:
                            fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 5:
                            fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 6:
                            fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 7:
                            fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;
                            System.out.println("You choosed: The file need to be " + fileModification.getChoice());
                            break;
                        case 8:
                            fileModification = FileModification.NO_MODIFICATION;
                            System.out.println("You choosed: No " + fileModification.getChoice());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                }
            }


            System.out.println("\n"); // For space


            System.out.println("Do you want to continue working with this folder: " +
                    nameOfFolderToSave + "?\n" +
                    "If yes, press 'Enter', otherwise enter the folder name:");

            while (true) {
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    break;
                } else {
                    nameOfFolderToSave = "files\\" + input;
                    break;
                }
            }

            if(FileModification.ENCRYPTED == fileModification){
                folderPath = nameOfFolderToSave;
                extensions = new String[]{".txt", ".xml", ".json"};
                matchingFiles = FileFilterByExtension.getFilesByExtensions(folderPath, extensions);

                if (!matchingFiles.isEmpty())
                {
                    System.out.println("Select the file name you want process (enter the number):");
                    for (int i = 0; i < matchingFiles.size(); ++i)
                    {
                        System.out.println(i+1 + ") " + matchingFiles.get(i));
                    }
                    System.out.print(">");
                } else
                {
                    System.out.println("There are no files with the specified extensions in the specified folder");
                    continue;
                }

                while (null == fileName) {
                    String input = scanner.nextLine();
                    try {
                        int chose = Integer.parseInt(input);
                        if(chose > 0 && chose <= matchingFiles.size()) {
                            fileName = folderPath + "\\" + matchingFiles.get(chose-1);
                            System.out.println("You choosed: " + matchingFiles.get(chose-1));
                        }
                        else throw new IllegalStateException("Unexpected value: " + chose);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Try again. Enter the number:");
                        System.out.print(">");
                    } catch (NumberFormatException e) {
                        System.out.println("This is not a number.\n" +
                                "Try again. Enter the number:");
                        System.out.print(">");
                    }
                }

                modifierBuilder = new GeneralModifierBuilderImpl();
                modifierBuilder.setDirectoryName(fileName);
                modifierBuilder.setKey(key);
                modifierBuilder.setFileModification(fileModification);
                generalModifier = modifierBuilder.build();

                try{
                    generalModifier.modifie();
                    System.out.println("Files were modified successfully");
                }catch (RuntimeException e){
                    System.out.println("Problems with file modifying:");
                    System.out.println(e.getMessage());
                }
            } else if (FileModification.NO_MODIFICATION != fileModification){
                switch (fileModification) {
                    case ARCHIVED_RAR, ARCHIVED_ZIP:
                        modifierBuilder = new GeneralModifierBuilderImpl();
                        modifierBuilder.setDirectoryName(nameOfFolderToSave);
                        modifierBuilder.setFileModification(fileModification);
                        generalModifier = modifierBuilder.build();
                        break;
                    default:
                        modifierBuilder = new GeneralModifierBuilderImpl();
                        modifierBuilder.setDirectoryName(nameOfFolderToSave);
                        modifierBuilder.setKey(key);
                        modifierBuilder.setFileModification(fileModification);
                        generalModifier = modifierBuilder.build();
                        break;
                }
                try{
                    generalModifier.modifie();
                    System.out.println("Files were modified successfully");
                }catch (RuntimeException e){
                    System.out.println("Problems with file modifying:");
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Select next action (enter the number):\n" +
                    "1) Process one more file\n" +
                    "2) Close program");
            System.out.print(">");

            String input;
            while (true) {
                input = scanner.nextLine();
                try {
                    switch (Integer.parseInt(input)) {
                        case 1:
                            System.out.println("You choosed: Unmodify one more file");
                            break;
                        case 2:
                            System.out.println("You choosed: Close program");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Integer.parseInt(input));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number.\n" +
                            "Try again. Enter the number:");
                    System.out.print(">");
                    continue;
                }
                break;
            }

            switch (Integer.parseInt(input)) {
                case 1:
                    fileName = null;
                    fileModification = null;
                    continue;
                case 2:
                    break;
            }
            break;
        }

        System.out.println("End");
    }
}