package AdditionalClasses;

import java.io.File;

public class FolderCreator {
    public static boolean createFolder(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.exists()) {
            if (folder.mkdirs()) {
                //System.out.println("Folder successfully created.");
                return true;
            } else {
                System.out.println("Failed to create the folder");
                return false;
            }
        } else {
            System.out.println("Attention: The folder already exists.");
            return true;
        }
    }
}

