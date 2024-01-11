package AdditionalClasses;

public enum FileTypeAndMethod
{
    JSON_API ("JSON file using the API"),
    JSON_FUNC ("JSON file using the function"),
    XML_API ("XML file using the API"),
    XML_FUNC ("XML file using the function"),
    TXT ("TXT file"),
    AUTO ("file with auto-type detection");

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
