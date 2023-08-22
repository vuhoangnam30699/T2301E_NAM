package Thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        if (!Files.exists(Paths.get("target"))) {
            throw new RuntimeException("File/folder not found");
        }
        try {
            Files.delete(Paths.get("target"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}