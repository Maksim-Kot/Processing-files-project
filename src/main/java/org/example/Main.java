package org.example;

import EquationClass.MathEquation;

import java.util.ArrayList;
import java.util.List;

import static Calculation.CalculationViaAPI.calculateViaAPI;
import static ReadAndWrite.JsonReadWrite.readFromJSONFile;
import static ReadAndWrite.MyJsonReadWrite.myWriteToJSONFile;
import static ReadAndWrite.MyXMLReadWrite.myReadFromXMLFile;
import static ReadAndWrite.MyXMLReadWrite.myWriteToXMLFile;
import static ReadAndWrite.TXTReadWrite.readFromTXTFile;
import static ReadAndWrite.TXTReadWrite.writeToTXTFile;
import static ReadAndWrite.XMLReadWrite.writeToXMLFile;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("\n" + "((1+2)*(5-4)/2+(1-2))/2 = " + calculateViaAPI("((1+2)*(5-4)/2+(1-2))/2"));
    }
}