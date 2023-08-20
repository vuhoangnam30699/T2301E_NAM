import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SecureDirectoryStream;
import java.util.ArrayList;
import java.util.List;

public class FileExplorer {

    private Path path;

    public FileExplorer() {
        this.path = Paths.get("C:\\Users\\Admin\\IdeaProjects\\FileExplorer");
    }

    public List<File> list() {
        List<File> files = new ArrayList<>();
        try {
            Files.walk(this.path).forEach(file -> files.add(file.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public String enter(String name) {
        File file = new File(this.path.resolve(name).toUri());
        if (file.isFile()) {
            try {
                Files.readString(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.isDirectory()) {
            this.path = file.toPath();
        } else {
            throw new RuntimeException("File/Folder not found");
        }
        return name;
    }

    public void createFile(String name, String content) {
        try {
            Path filePath = this.path.resolve(name);
            Files.writeString(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFolder(String name) {
        try {
            Path folderPath = this.path.resolve(name);
            Files.createDirectory(folderPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String name) throws IOException {
        File file = new File(this.path.resolve(name).toUri());
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            SecureDirectoryStream<File> FileUtils = null;
            FileUtils.deleteDirectory(file);
        } else {
            throw new RuntimeException("File/Folder not found");
        }
    }

    public void rename(String currentName, String newName) {
        File currentFile = new File(this.path.resolve(currentName).toUri());
        File newFile = new File(this.path.resolve(newName).toUri());
        currentFile.renameTo(newFile);
    }
}