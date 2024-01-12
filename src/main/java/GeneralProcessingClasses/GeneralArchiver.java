package GeneralProcessingClasses;

import AdditionalClasses.FileModification;
import Archivers.WinRARFileManager;
import Archivers.ZipFileManager;

import java.io.File;
import java.io.IOException;

public class GeneralArchiver {
    public static void dearchive (String nameOfArchive, String directoryName, FileModification fileModification) {
        try{
            switch (fileModification) {
                case ARCHIVED_ZIP:
                    ZipFileManager.unzipFiles("files\\" + nameOfArchive, "files\\" + directoryName);
                    if(isFolderEmpty("files\\" + directoryName)){
                        deleteFolder("files\\" + directoryName);
                        throw new IllegalArgumentException("This is not a .zip archive");
                    }
                    break;
                case ARCHIVED_RAR:
                    WinRARFileManager.extractRAR("files\\" + nameOfArchive, "files\\" + directoryName);
                    break;
            }
        } catch (IllegalArgumentException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void archive (String nameOfFolder, FileModification fileModification) {
        try{
            switch (fileModification) {
                case ARCHIVED_ZIP:
                    ZipFileManager.zipFiles(nameOfFolder);
                    break;
                case ARCHIVED_RAR:
                    WinRARFileManager.createRAR(nameOfFolder, "D:\\Other project\\Java\\end-to-end_project\\"+nameOfFolder+".rar");
                    break;
            }
        } catch (IllegalArgumentException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static boolean isFolderEmpty(String folderPath) {
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            String[] files = folder.list();
            return files == null || files.length == 0;
        }

        return false;
    }

    public static void deleteFolder(String folderPath) {
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            if (isFolderEmpty(folderPath)) {
                if (!folder.delete()) {
                    System.out.println("Failed to delete the folder.");
                }
            }
        }
    }
}
