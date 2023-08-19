package WorkWithJavaFile;

import java.io.File;
import java.util.Date;


public class Test {
    public static void main(String[] args) {
        // Tao original-folder
        File file = new File("original-folder");
        file.mkdir();

        String originalFolderPath = "original-folder";
        String destFolderPath = originalFolderPath + "/dest-folder";

        String file1Path = originalFolderPath + "/file1.txt";
        String file2Path = originalFolderPath + "/file2.txt";
        String file3Path = originalFolderPath + "/file3.txt";
        String file4Path = originalFolderPath + "/file4.txt";
        String file5Path = originalFolderPath + "/file5.txt";

        // Tao dest-folder
        File destFolder = new File(destFolderPath);
        destFolder.mkdir();

        // Di chuyen file 1
        File file1 = new File(file1Path);
        File destFile1 = new File(destFolderPath + "/file1.txt");
        file1.renameTo(destFile1);

        // Di chuyen file 2
        File file2 = new File(file2Path);
        File destFile2 = new File(destFolderPath + "/file2.txt");
        file2.renameTo(destFile2);

        // Xoa file 5
        File file5 = new File(file5Path);
        file5.delete();

        // In ra cac file trong dest-folder + thoi diem + size
        for (File f : destFolder.listFiles()) {
            System.out.println(
                    f.getName() + " " +
                    new Date(f.lastModified()) + " " +
                    f.length()
            );
        }

    }
}
