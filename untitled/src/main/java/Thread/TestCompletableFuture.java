package Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> thread1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(1);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> thread2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.get();
        thread2.get();
    }
}
