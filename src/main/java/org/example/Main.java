package org.example;

import AdditionalClasses.FileModification;
import AdditionalClasses.FileTypeAndMethod;
import AdditionalClasses.MethodToCalculate;
import EquationClass.MathEquation;
import ReadAndWrite.*;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FileModification fileModification = null;
        FileTypeAndMethod fileTypeAndMethod = null;
        MethodToCalculate methodToCalculate = null;
        List<MathEquation> eq = null;
        String fileName = "";

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

        System.out.println("Enter the full name of the file you want to read and process:");
        System.out.print(">");
        fileName = scanner.nextLine();

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
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        if(null == eq) System.out.println("Problems with file");
        else {
            System.out.println("Good!");
            System.out.println(eq);
        }
    }
}