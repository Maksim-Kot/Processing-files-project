package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyJsonReadWrite {

    public static List<MathEquation> myReadFromJSONFile(String filePath)
    {
        List<MathEquation> equations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().regionMatches(1, "result", 0, 6)) {
                    String result = line.substring(line.indexOf(':') + 2, line.lastIndexOf(','));
                    line = br.readLine();
                    String variables = line.substring(line.indexOf(':') + 3, line.lastIndexOf(',') - 1);
                    line = br.readLine();
                    String equation = line.substring(line.indexOf(':') + 3, line.length() - 1);


                    equations.add(new MathEquation(equation, variables, Double.parseDouble(result)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equations;
    }

    public static void myWriteToJSONFile(List<MathEquation> equations, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("[\n");


            for (int i = 0; i < equations.size(); ++i) {
                bw.write("\t{\n");
                bw.write("\t\t\"result\": " + equations.get(i).getResult() + ",\n");
                bw.write("\t\t\"variables\": \"" + equations.get(i).getVariables() + "\",\n");
                bw.write("\t\t\"equation\": \"" + equations.get(i).getEquation() + "\"\n");
                if(i == equations.size() -1) bw.write("\t}\n");
                else bw.write("\t},\n");
            }

            bw.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
