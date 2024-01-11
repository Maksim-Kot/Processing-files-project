package org.example;

import AdditionalClasses.FileFilterByExtension;
import AdditionalClasses.FileModification;
import AdditionalClasses.FileTypeAndMethod;
import AdditionalClasses.MethodToCalculate;
import GeneralProcessingClasses.GeneralArchiver;
import EquationClass.MathEquation;
import GeneralProcessingClasses.GeneralCalculation;
import GeneralProcessingClasses.GeneralReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        FileModification fileModification = null;
        FileTypeAndMethod fileTypeAndMethod = null;
        MethodToCalculate methodToCalculate = null;
        List<MathEquation> eq = null;
        List<MathEquation> calculatedEq = null;
        String archiverName = null;
        String outputFolder = "output";
        String fileName = null;
        String folderPath = "";
        String[] extensions = null;
        List<String> matchingFiles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("This program will help you:\n" +
                "- perform operations on files;\n" +
                "- calculate the values of expressions written in files;\n" +
                "- save the result in a format convenient for you.\n" +
                "To start press 'Enter'");

        Boolean isEnter = true;
        while (isEnter) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                isEnter = false;
            } else {
                System.out.println("You enter: " + input);
                System.out.println("Please, press 'Enter' to continue");
            }
        }


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
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 2:
                        fileModification = FileModification.ARCHIVED_RAR;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 3:
                        fileModification = FileModification.ENCRYPTED;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 4:
                        fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_ZIP;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 5:
                        fileModification = FileModification.ENCRYPTED_THEN_ARCHIVED_RAR;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 6:
                        fileModification = FileModification.ARCHIVED_ZIP_THEN_ENCRYPTED;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 7:
                        fileModification = FileModification.ARCHIVED_RAR_THEN_ENCRYPTED;
                        System.out.println("You choosed: " + fileModification.getChoice());
                        break;
                    case 8:
                        fileModification = FileModification.NO_MODIFICATION;
                        System.out.println("You choosed: " + fileModification.getChoice());
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

        System.out.println(); // For space


        // Dearchiving file
        try{
            GeneralArchiver.dearchive(archiverName, outputFolder, fileModification);
            System.out.println("Files were dearchived successfully");
        }catch (RuntimeException e){
            System.out.println("Problems with file dearchiving:");
            System.out.println(e.getMessage());
            return;
        }


        System.out.println("\n"); // For space


        folderPath = "files\\" + outputFolder;
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
        }

        while (null == fileName) {
            String input = scanner.nextLine();
            try {
                int chose = Integer.parseInt(input);
                if(chose > 0 && chose <= matchingFiles.size()) {
                    fileName = "files\\output\\" + matchingFiles.get(chose-1);
                    System.out.println("You choosed: " + fileName);
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
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
                        break;
                    case 2:
                        fileTypeAndMethod = FileTypeAndMethod.JSON_FUNC;
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
                        break;
                    case 3:
                        fileTypeAndMethod = FileTypeAndMethod.XML_API;
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
                        break;
                    case 4:
                        fileTypeAndMethod = FileTypeAndMethod.XML_FUNC;
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
                        break;
                    case 5:
                        fileTypeAndMethod = FileTypeAndMethod.TXT;
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
                        break;
                    case 6:
                        fileTypeAndMethod = FileTypeAndMethod.AUTO;
                        System.out.println("You choosed: " + fileTypeAndMethod.getChoice());
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
        if(null == eq) System.out.println("Problems with file");
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


        System.out.println("\n"); // For space

        GeneralCalculation generalCalculation = new GeneralCalculation();
        calculatedEq = generalCalculation.calculate(eq, methodToCalculate);
        if(generalCalculation.isHaveMistakes()){
            for(String message: generalCalculation.getMistakes()){
                System.out.println(message);
            }
        } else {
            System.out.println("The file was processed successfully");
        }


        System.out.println("\n"); // For space


        System.out.println(calculatedEq);
    }
}