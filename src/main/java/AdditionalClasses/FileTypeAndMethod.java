package AdditionalClasses;

public enum FileTypeAndMethod
{
    JSON_API ("Read JSON file using the API"),
    JSON_FUNC ("Read JSON file using the function"),
    XML_API ("Read XML file using the API"),
    XML_FUNC ("Read XML file using the function"),
    TXT ("Read TXT file"),
    AUTO ("Read file with auto-type detection");

    private String str;

    public String getChoice()
    {
        return str;
    }

    FileTypeAndMethod(String str)
    {
        this.str = str;
    }
}
