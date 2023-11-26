package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReadWrite
{
    public static List<MathEquation> readFromJSONFile(String filePath)
    {
        List<MathEquation> equations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                content.append(line);
            }

            JSONArray jsonArray = new JSONArray(content.toString());

            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String equation = jsonObject.getString("equation");
                String variables = jsonObject.getString("variables");
                int result = jsonObject.getInt("result");
                equations.add(new MathEquation(equation, variables, result));
            }

            return equations;
        }
        catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToJSONFile(List<MathEquation> equations, String filePath)
    {
        JSONArray jsonArray = new JSONArray();

        for (MathEquation equation : equations)
        {
            JSONObject equationJson = new JSONObject();
            equationJson.put("equation", equation.getEquation());
            equationJson.put("variables", equation.getVariables());
            equationJson.put("result", equation.getResult());
            jsonArray.put(equationJson);
        }

        try (FileWriter file = new FileWriter(filePath))
        {
            file.write(jsonArray.toString(4));
            //System.out.println("Objects successfully written to JSON file!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
