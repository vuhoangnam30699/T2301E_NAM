package thread_multithread;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

public class CFMain {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        List<String> files = new CopyOnWriteArrayList<>(
                List.of("file1.txt", "file2.txt", "file3.txt")
        );
        List<Integer> sums = new CopyOnWriteArrayList<>();

        CompletableFuture<Void> thread1 = CompletableFuture.runAsync(() -> FileUtils.calculateSums(files, sums));
        CompletableFuture<Void> thread2 = CompletableFuture.runAsync(() -> FileUtils.calculateSums(files, sums));

        thread1.get();
        thread2.get();

        System.out.println(sums);

    }
}