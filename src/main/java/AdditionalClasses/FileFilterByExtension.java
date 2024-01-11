package AdditionalClasses;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileFilterByExtension {

    public static List<String> getFilesByExtensions(String folderPath, String... extensions) {
        List<String> matchingFiles = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    for (String extension : extensions) {
                        if (name.toLowerCase().endsWith(extension.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                }
            };

            File[] files = folder.listFiles(filter);

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        matchingFiles.add(file.getName());
                    }
                }
            }
        }

        return matchingFiles;
    }
}

