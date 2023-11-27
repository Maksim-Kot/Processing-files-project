package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.JsonReadWrite.readFromJSONFile;
import static org.example.JsonReadWrite.writeToJSONFile;
import static org.example.TXTReadWrite.readFromTXTFile;
import static org.example.TXTReadWrite.writeToTXTFile;
import static org.example.XMLReadWrite.readFromXML;
import static org.example.XMLReadWrite.writeToXML;


public class Main {
    public static void main(String[] args)
    {
        List<MathEquation> equations1 = new ArrayList<>();
        equations1.add(new MathEquation("x + y = 10", "x, y", 7));
        equations1.add(new MathEquation("2 * z = 16", "z", 8));

        writeToJSONFile(equations1, "equations.json");


        List<MathEquation> equations2 = readFromJSONFile("equations.json");
        if (equations2 != null)
        {
            for (MathEquation equation : equations2)
            {
                System.out.println("Equation: " + equation.getEquation() + ", Variables: " +
                        equation.getVariables() + ", Result: " + equation.getResult());
            }
        }

        System.out.println();

        List<MathEquation> equations = new ArrayList<>();
        equations.add(new MathEquation("x + y = 10", "x, y", 7));
        equations.add(new MathEquation("2 * a = 8", "a", 4));

        // Запись коллекции в XML файл
        writeToXML(equations, "equations.xml");

        // Чтение коллекции из XML файла
        List<MathEquation> loadedEquations = readFromXML("equations.xml");
        for (MathEquation equation : loadedEquations)
        {
            System.out.println("Equation: " + equation.getEquation() + ", Variables: " + equation.getVariables() + ", Result: " + equation.getResult());
        }


        // Добавление новых уравнений в коллекцию (пример)
        //equations.add(new MathEquation("2x + 5 = 10", "x", 5));
        //equations.add(new MathEquation("3y - 7 = 14", "y", 7));
        System.out.println();
        writeToTXTFile(equations, "equations.txt");

        List<MathEquation> equations3 = readFromTXTFile("equations.txt");
        for (MathEquation equation : equations3)
        {
            System.out.println("Equation: " + equation.getEquation() + ", Variables: " + equation.getVariables() + ", Result: " + equation.getResult());
        }

    }
}