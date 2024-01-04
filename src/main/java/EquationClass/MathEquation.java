package EquationClass;
import javax.xml.bind.annotation.*;
import java.util.Objects;

public class MathEquation
{
    private String equation;
    private String variables;
    private double result;

    public MathEquation()
    {
        // Обязательно должен быть пустой конструктор для JAXB
    }

    public MathEquation(String equation, String variables, double result)
    {
        this.equation = equation;
        this.variables = variables;
        this.result = result;
    }

    @XmlElement
    public String getEquation()
    {
        return equation;
    }

    public void setEquation(String equation)
    {
        this.equation = equation;
    }

    @XmlElement
    public String getVariables()
    {
        return variables;
    }

    public void setVariables(String variables)
    {
        this.variables = variables;
    }

    @XmlElement
    public double getResult()
    {
        return result;
    }

    public void setResult(double result)
    {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathEquation that = (MathEquation) o;
        return result == that.result && Objects.equals(equation, that.equation) && Objects.equals(variables, that.variables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation, variables, result);
    }
}
