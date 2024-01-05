package Calculation;

public class StringPreparationForFunction
{
    public static String preparation(String s)
    {
        s = deleteSeparators(s);
        s = handlingNumbers(s);
        return s;
    }

    static String deleteSeparators(String s)
    {
        return s.replaceAll("\\s+", "");
    }

    static String handlingNumbers(String s)
    {
        StringBuilder resultString = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; --i)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                while(i >= 0 && Character.isDigit(s.charAt(i)))
                {
                    resultString.insert(0, s.charAt(i));
                    --i;
                }
                if(i >= 0 && s.charAt(i) == '.')
                {
                    if(-1 == i-1)
                    {
                        resultString.insert(0, '.').insert(0, '0').insert(0, " ");
                        break;
                    }
                    else if(!Character.isDigit(s.charAt(i-1)))
                    {
                        resultString.insert(0, '.').insert(0, '0').insert(0, " ");
                    }
                    else resultString.insert(0, '.');
                }
                else
                {
                    resultString.insert(0, " ");
                    ++i;
                }
            }
            else
            {
                if(s.charAt(i) == '-' && s.charAt(i-1) == '(')
                {
                    resultString.insert(0, s.charAt(i)).insert(0, " ");
                    resultString.insert(0, '0').insert(0, " ");
                }
                else resultString.insert(0, s.charAt(i)).insert(0, " ");
            }

        }
        return resultString.toString().trim();
    }
}
