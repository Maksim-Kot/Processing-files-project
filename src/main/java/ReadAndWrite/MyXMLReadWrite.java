package ReadAndWrite;
import EquationClass.MathEquation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class MyXMLReadWrite {
    public static List<MathEquation> myReadFromXMLFile(String filePath) {
        List<MathEquation> equations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("<equation>")) {
                    String equation = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
                    line = br.readLine();
                    String result = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
                    line = br.readLine();
                    String variables = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));

                    equations.add(new MathEquation(equation, variables, Double.parseDouble(result)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equations;
    }

    public static void myWriteToXMLFile(List<MathEquation> equations, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
            bw.write("<listWrapper>\n");

            for (MathEquation equation : equations) {
                bw.write("\t<mathequation>\n");
                bw.write("\t\t<equation>" + equation.getEquation() + "</equation>\n");
                bw.write("\t\t<result>" + equation.getResult() + "</result>\n");
                bw.write("\t\t<variables>" + equation.getVariables() + "</variables>\n");
                bw.write("\t</mathequation>\n");
            }

            bw.write("</listWrapper>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
