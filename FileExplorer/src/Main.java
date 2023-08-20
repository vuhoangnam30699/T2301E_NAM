import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileExplorer fileExplorer = new FileExplorer();

        // Test list() method
        List<File> files = fileExplorer.list();
        System.out.println("Files in the current directory:");
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Test enter() method
        String content = fileExplorer.enter("test.txt");
        System.out.println("Content of the file test.txt:");
        System.out.println(content);

        // Test createFile() method
        fileExplorer.createFile("new_file.txt", "This is the content of the new file.");
        System.out.println("Created a new file called new_file.txt");

        // Test createFolder() method
        fileExplorer.createFolder("new_folder");
        System.out.println("Created a new folder called new_folder");

        // Test delete() method
        fileExplorer.delete("new_file.txt");
        System.out.println("Deleted the file new_file.txt");

        // Test rename() method
        fileExplorer.rename("new_folder", "old_folder");
        System.out.println("Renamed the folder new_folder to old_folder");    }
}