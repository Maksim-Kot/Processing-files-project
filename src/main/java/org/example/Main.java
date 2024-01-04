package org.example;

import EquationClass.MathEquation;

import java.util.ArrayList;
import java.util.List;

import static Calculation.CalculationViaAPI.calculateViaAPI;
import static Calculation.CalculationViaParsing.calculateViaParsing;
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
        //String expression = "( ( 0 - 1.0 + 2 ) * ( 5.78 + ( 0 - 4 ) ) / 2 + ( 0.7 - 0.8 ) ) / 2";
        String expression = "( (1.0 + 2 ) * (5.78 +(-4) ) / 2 + ( 0.7- .8) ) / 2";
        //String expression = "((0 - 1.0 + 2) * (5.78 + (0 - 4)))";

        // Evaluate an expression
        Double myResult = calculateViaParsing(expression);
        Double result = calculateViaAPI(expression);

        // Ouput the result
        System.out.println(expression + " = " + result);
        System.out.println(expression + " = " + myResult);
    }
}