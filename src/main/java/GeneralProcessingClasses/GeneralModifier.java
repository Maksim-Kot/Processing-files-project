package GeneralProcessingClasses;

import AdditionalClasses.FileFilterByExtension;
import AdditionalClasses.FileModification;
import Archivers.WinRARFileManager;
import Archivers.ZipFileManager;
import Encryption.Encrypter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static Archivers.Archiver.archive;
import static Archivers.Archiver.dearchive;

public class GeneralModifier {
    public static void unmodifie(String nameOfArchive, String directoryName, String key, FileModification fileModification) {
        try{
            switch (fileModification) {
                case ARCHIVED_ZIP, ARCHIVED_RAR:
                    dearchive(nameOfArchive, directoryName, fileModification);
                    break;
                case ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP:
                    dearchive(nameOfArchive, directoryName, fileModification);
                    List<String> files= FileFilterByExtension.getFilesByExtensions(directoryName, ".enc");
                    for (String file: files){
                        file = directoryName + "\\" + file;
                        String newFile = file.replaceAll("\\.enc$", "");
                        Encrypter.decrypt(file, newFile, key);
                    }
                    break;
                case ARCHIVED_RAR_THEN_ENCRYPTED, ARCHIVED_ZIP_THEN_ENCRYPTED:
                    String newFile = nameOfArchive.replaceAll("\\.enc$", "");
                    Encrypter.decrypt(nameOfArchive, newFile, key);
                    dearchive(newFile, directoryName, fileModification);
                    break;
                case ENCRYPTED:
                    String newName = nameOfArchive.replaceAll("\\.enc$", "");
                    newName = newName.substring(newName.indexOf('\\') + 1);
                    newName = directoryName + "\\" + newName;
                    Encrypter.decrypt(nameOfArchive, newName, key);
                case NO_MODIFICATION:
                    break;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void modifie(String nameOfFolder, String key, FileModification fileModification) {
        try{
            switch (fileModification) {
                case ARCHIVED_ZIP, ARCHIVED_RAR:
                    archive(nameOfFolder, fileModification);
                    break;
                case ENCRYPTED_THEN_ARCHIVED_RAR, ENCRYPTED_THEN_ARCHIVED_ZIP:
                    List<String> files= FileFilterByExtension.getFilesByExtensions(nameOfFolder, ".txt", ".xml", ".json");
                    for (String file: files){
                        file = nameOfFolder + "\\" + file;
                        String newFile = file + ".enc";
                        Encrypter.encrypt(file, newFile, key);
                    }
                    archive(nameOfFolder, fileModification);
                    break;
                case ARCHIVED_RAR_THEN_ENCRYPTED, ARCHIVED_ZIP_THEN_ENCRYPTED:
                    archive(nameOfFolder, fileModification);
                    if(FileModification.ARCHIVED_RAR_THEN_ENCRYPTED == fileModification){
                        Encrypter.encrypt(nameOfFolder + ".rar", nameOfFolder + ".rar.enc", key);
                        File file = new File(nameOfFolder + ".rar");
                        file.delete();
                    } else {
                        Encrypter.encrypt(nameOfFolder + ".zip", nameOfFolder + ".zip.enc", key);
                        File file = new File(nameOfFolder + ".zip");
                        file.delete();
                    }
                    break;
                case ENCRYPTED:
                    Encrypter.encrypt(nameOfFolder, nameOfFolder + ".enc", key);
                case NO_MODIFICATION:
                    break;
            }
        } catch (RuntimeException e) {
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
