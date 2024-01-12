package AdditionalClasses;

public enum FileModification
{
    ARCHIVED_ZIP ("archived (ZIP)"),
    ARCHIVED_RAR ("archived (RAR)"),
    ENCRYPTED ("encrypted"),
    ARCHIVED_ZIP_THEN_ENCRYPTED ("archived (ZIP) and then encrypted"),
    ARCHIVED_RAR_THEN_ENCRYPTED ("archived (RAR) and then encrypted"),
    ENCRYPTED_THEN_ARCHIVED_ZIP ("encrypted and then archived (ZIP)"),
    ENCRYPTED_THEN_ARCHIVED_RAR ("encrypted and then archived (RAR)"),
    NO_MODIFICATION ("modified");

    private String str;

    public String getChoice()
    {
        return str;
    }

    FileModification(String str)
    {
        this.str = str;
    }
}
