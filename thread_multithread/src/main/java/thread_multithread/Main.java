package thread_multithread;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> files = new CopyOnWriteArrayList<>(
                List.of("file1.txt", "file2.txt", "file3.txt")
        );
        List<Integer> sums = new CopyOnWriteArrayList<>();

        FileSumThread thread1 = new FileSumThread(files, sums);
        FileSumThread thread2 = new FileSumThread(files, sums);
        FileSumThread thread3 = new FileSumThread(files, sums);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(sums);

    }
}