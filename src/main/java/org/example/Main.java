package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.JsonReadWrite.readFromJSONFile;
import static org.example.JsonReadWrite.writeToJSONFile;
import static org.example.MyJsonReadWrite.myReadFromJSONFile;
import static org.example.MyJsonReadWrite.myWriteToJSONFile;
import static org.example.MyXMLReadWrite.myReadFromXMLFile;
import static org.example.MyXMLReadWrite.myWriteToXMLFile;
import static org.example.TXTReadWrite.readFromTXTFile;
import static org.example.TXTReadWrite.writeToTXTFile;
import static org.example.XMLReadWrite.readFromXMLFile;
import static org.example.XMLReadWrite.writeToXMLFile;


public class Main {
    public static void main(String[] args)
    {
        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * z = 16", "z", 8));
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        myWriteToJSONFile(equations, "myequations.json");


        List<MathEquation> equationsjson = readFromJSONFile("myequations.json");
        if (equationsjson != null)
        {
            for (MathEquation equation : equationsjson)
            {
                System.out.println("Equation: " + equation.getEquation() + ", Variables: " +
                        equation.getVariables() + ", Result: " + equation.getResult());
            }
        }

        System.out.println();


        // Запись коллекции в XML файл
        writeToXMLFile(equations, "equations.xml");
        myWriteToXMLFile(equations, "myequations.xml");

        // Чтение коллекции из XML файла
        List<MathEquation> loadedEquations = myReadFromXMLFile("myequations.xml");
        for (MathEquation equation : loadedEquations)
        {
            System.out.println("Equation: " + equation.getEquation() + ", Variables: " + equation.getVariables() + ", Result: " + equation.getResult());
        }


        System.out.println();
        writeToTXTFile(equations, "equations.txt");


        List<MathEquation> equationstxt = readFromTXTFile("equations.txt");
        for (MathEquation equation : equationstxt)
        {
            System.out.println("Equation: " + equation.getEquation() + ", Variables: " + equation.getVariables() + ", Result: " + equation.getResult());
        }

    }
}