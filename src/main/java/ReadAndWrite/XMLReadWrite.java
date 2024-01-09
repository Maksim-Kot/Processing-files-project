package ReadAndWrite;

import EquationClass.MathEquation;

import javax.xml.bind.annotation.*;
import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
public class XMLReadWrite
{

    public static List<MathEquation> readFromXMLFile(String filePath)
    {
        try
        {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + filePath);
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(MathEquation.class, ListWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ListWrapper wrapper = (ListWrapper) unmarshaller.unmarshal(file);
            return wrapper.getMathEquations();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
        catch (JAXBException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void writeToXMLFile(List<MathEquation> equations, String filePath)
    {
        try
        {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(MathEquation.class, XMLReadWrite.ListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            XMLReadWrite.ListWrapper wrapper = new XMLReadWrite.ListWrapper();
            wrapper.setMathEquations(equations);
            marshaller.marshal(wrapper, file);
        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @XmlRootElement
    static class ListWrapper
    {
        private List<MathEquation> equations;

        @XmlElement(name = "mathequation")
        public List<MathEquation> getMathEquations()
        {
            return equations;
        }

        public void setMathEquations(List<MathEquation> equations)
        {
            this.equations = equations;
        }
    }
}
