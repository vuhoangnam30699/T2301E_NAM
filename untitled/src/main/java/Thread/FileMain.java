package Thread;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FileMain {
    @SneakyThrows
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeFile("text 1");
        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeFile("text 2");
        }
//        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                writeFile("text 1");
//            }
//        });
//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                writeFile("text 2");
//            }
//        });
//
//        future1.get();
//        future2.get();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @SneakyThrows
    private synchronized static void writeFile(String content) {
        Path path = Paths.get("test.txt");
        List<String> lines = Files.readAllLines(path);
        lines.add(content);
        Files.write(path, lines);
    }
}