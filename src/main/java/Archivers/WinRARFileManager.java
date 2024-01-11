package Archivers;

import java.io.File;
import java.io.IOException;

public class WinRARFileManager
{

    // Method for creating a RAR archive
    public static void createRAR(String sourceDir, String targetRAR) throws IOException {
        File targetFile = new File(targetRAR);
        targetFile.getParentFile().mkdirs(); // Create directories if they don't exist

        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\WinRAR\\WinRAR.exe", "a", targetRAR, "*.*");
        processBuilder.directory(new File(sourceDir));

        // If you need to wait for the process to complete
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method for extracting from RAR archive
    public static void extractRAR(String sourceRAR, String targetDir) throws IOException
    {
        File destDir = new File(targetDir);

        // Create a directory if it doesn't exist
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\WinRAR\\WinRAR.exe", "x", sourceRAR, targetDir);
        Process process = processBuilder.start();

        // If you need to wait for the process to complete
        try {
            process.waitFor();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

