package Archivers;

import AdditionalClasses.FileModification;

import java.io.File;
import java.io.IOException;

public class Archiver {
    public static void dearchive (String nameOfArchive, String directoryName, FileModification fileModification) {
        try{
            switch (fileModification) {
                case ARCHIVED_ZIP, ENCRYPTED_THEN_ARCHIVED_ZIP, ARCHIVED_ZIP_THEN_ENCRYPTED:
                    ZipFileManager.unzipFiles(nameOfArchive, directoryName);
                    if(isFolderEmpty(directoryName)){
                        deleteFolder(directoryName);
                        throw new IllegalArgumentException("This is not a .zip archive");
                    }
                    break;
                case ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_RAR, ARCHIVED_RAR_THEN_ENCRYPTED:
                    WinRARFileManager.extractRAR(nameOfArchive, directoryName);
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
