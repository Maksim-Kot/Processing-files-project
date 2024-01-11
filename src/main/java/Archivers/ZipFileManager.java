package Archivers;

import java.io.*;
import java.util.zip.*;

public class ZipFileManager
{

    // Method for archiving files in ZIP
    public static void zipFiles(String sourceFolder) throws IOException
    {
        File sourceDir = new File(sourceFolder);
        if (!sourceDir.isDirectory())
        {
            throw new IOException("Source must be a directory");
        }

        String zipFileName = sourceDir.getParent() + File.separator + sourceDir.getName() + ".zip";
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);

        try
        {
            addToZipFile(sourceDir, zos, sourceDir);
        } finally
        {
            zos.close();
            fos.close();
        }
    }

    private static void addToZipFile(File source, ZipOutputStream zos, File rootDir) throws IOException
    {
        File[] files = source.listFiles();

        if (files != null)
        {
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    addToZipFile(file, zos, rootDir);
                } else
                {
                    String entryName = rootDir.toURI().relativize(file.toURI()).getPath().replace(File.separator, "/");
                    FileInputStream fis = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(entryName);
                    zos.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0)
                    {
                        zos.write(bytes, 0, length);
                    }

                    zos.closeEntry();
                    fis.close();
                }
            }
        }
    }

    // Method for dearchiving a ZIP file
    public static void unzipFiles(String zipFileName, String outputFolder) throws IOException
    {
        File destDir = new File(outputFolder);
        if (!destDir.exists())
        {
            destDir.mkdir();
        }

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName));
        ZipEntry zipEntry = zis.getNextEntry();

        while (zipEntry != null)
        {
            File newFile = newFile(destDir, zipEntry);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0)
            {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }

        zis.close();
    }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException
    {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator))
        {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}



