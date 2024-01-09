package ReadAndWrite;

import EquationClass.MathEquation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXTReadWrite
{
    // Method for reading the MathEquation collection from a file
    public static List<MathEquation> readFromTXTFile(String filename)
    {
        List<MathEquation> equations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split("; ");
                if (parts.length == 3)
                {
                    String equation = parts[0];
                    String variables = parts[1];
                    double result = Double.parseDouble(parts[2]);
                    equations.add(new MathEquation(equation, variables, result));
                }
            }
            if(equations.isEmpty()) throw new IllegalArgumentException("No valid information in file");
        } catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        } catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
        return equations;
    }

    // Method for writing the MathEquation collection to a file
    public static void writeToTXTFile(List<MathEquation> equations, String filename)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            for (MathEquation equation : equations)
            {
                bw.write(equation.getEquation() + "; " + equation.getVariables() + "; " + equation.getResult());
                bw.newLine();
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
