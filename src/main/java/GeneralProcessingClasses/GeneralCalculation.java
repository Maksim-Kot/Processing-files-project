package GeneralProcessingClasses;

import AdditionalClasses.MethodToCalculate;
import Calculation.CalculationViaAPI;
import Calculation.CalculationViaFunction;
import Calculation.CalculationViaRegex;
import EquationClass.MathEquation;
import VariablesReplacement.VariablesReplacement;

import java.util.ArrayList;
import java.util.List;

public class GeneralCalculation {
    private boolean haveMistakes;
    private List<String> mistakes;

    public GeneralCalculation(){
        haveMistakes = false;
        mistakes = new ArrayList<>();
    }

    public List<MathEquation> calculate(List<MathEquation> eq, MethodToCalculate methodToCalculate){
        List<MathEquation> res = new ArrayList<>();
        switch (methodToCalculate) {
            case API:
                for (int i = 0; i < eq.size(); ++i){
                    MathEquation mathEquation;
                    String equation = eq.get(i).getEquation();
                    String variables = eq.get(i).getVariables();
                    double result;
                    try{
                        equation = VariablesReplacement.replaceVariables(equation, variables);
                    } catch (IllegalArgumentException e){
                        addMistake(i+1, e.getMessage());
                        //variables = "Error: " + variables;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    try {
                        result = CalculationViaAPI.calculateViaAPI(equation);
                    } catch (Exception e){
                        addMistake(i+1, e.getMessage());
                        //equation = "Error: " + equation;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    mathEquation = new MathEquation(equation, variables, result);
                    res.add(mathEquation);
                }
                break;
            case FUNC:
                for (int i = 0; i < eq.size(); ++i){
                    MathEquation mathEquation;
                    String equation = eq.get(i).getEquation();
                    String variables = eq.get(i).getVariables();
                    double result;
                    try{
                        equation = VariablesReplacement.replaceVariables(equation, variables);
                    } catch (IllegalArgumentException e){
                        addMistake(i+1, e.getMessage());
                        //variables = "Error: " + variables;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    try {
                        result = CalculationViaFunction.calculateViaFunction(equation);
                    } catch (IllegalArgumentException | ArithmeticException e){
                        addMistake(i+1, e.getMessage());
                        //equation = "Error: " + equation;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    mathEquation = new MathEquation(equation, variables, result);
                    res.add(mathEquation);
                }
                break;
            case REGEX:
                for (int i = 0; i < eq.size(); ++i){
                    MathEquation mathEquation;
                    String equation = eq.get(i).getEquation();
                    String variables = eq.get(i).getVariables();
                    double result;
                    try{
                        equation = VariablesReplacement.replaceVariables(equation, variables);
                    } catch (IllegalArgumentException e){
                        addMistake(i+1, e.getMessage());
                        //variables = "Error: " + variables;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    try {
                        result = CalculationViaRegex.calculateViaRegex(equation);
                    } catch (IllegalArgumentException | ArithmeticException e){
                        addMistake(i+1, e.getMessage());
                        //equation = "Error: " + equation;
                        mathEquation = new MathEquation(equation, variables, 0);
                        res.add(mathEquation);
                        continue;
                    }
                    mathEquation = new MathEquation(equation, variables, result);
                    res.add(mathEquation);
                }
                break;
        }
        return res;
    }

    public boolean isHaveMistakes() {
        return haveMistakes;
    }

    public List<String> getMistakes() {
        return mistakes;
    }

    private void addMistake(int number, String error){
        haveMistakes = true;
        String s = "Number (" + number +"): " + error;
        mistakes.add(s);
    }
}
