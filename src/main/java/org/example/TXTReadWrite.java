package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXTReadWrite {
    // Метод для чтения коллекции MathEquation из файла
    public static List<MathEquation> readFromTXTFile(String filename) {
        List<MathEquation> equations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("; ");
                if (parts.length == 3) {
                    String equation = parts[0];
                    String variables = parts[1];
                    double result = Double.parseDouble(parts[2]);
                    equations.add(new MathEquation(equation, variables, result));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return equations;
    }

    // Метод для записи коллекции MathEquation в файл
    public static void writeToTXTFile(List<MathEquation> equations, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (MathEquation equation : equations) {
                bw.write(equation.getEquation() + "; " + equation.getVariables() + "; " + equation.getResult());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
