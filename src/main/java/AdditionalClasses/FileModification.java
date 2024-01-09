package AdditionalClasses;

public enum FileModification
{
    ARCHIVED_ZIP ("The file has been archived (ZIP)"),
    ARCHIVED_RAR ("The file has been archived (RAR)"),
    ENCRYPTED ("The file has been encrypted"),
    ARCHIVED_ZIP_THEN_ENCRYPTED ("The file was archived (ZIP) and then encrypted"),
    ARCHIVED_RAR_THEN_ENCRYPTED ("The file was archived (RAR) and then encrypted"),
    ENCRYPTED_THEN_ARCHIVED_ZIP ("The file was encrypted and then archived (ZIP)"),
    ENCRYPTED_THEN_ARCHIVED_RAR ("The file was encrypted and then archived (RAR)"),
    NO_MODIFICATION ("The file has not been modified");

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
