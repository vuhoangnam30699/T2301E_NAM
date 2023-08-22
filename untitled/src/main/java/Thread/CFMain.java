package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            addNumber(list, 1);
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            addNumber(list, 2);
        });

        future1.get();
        future2.get();

        System.out.println(list.size());
    }

    private static synchronized void addNumber(List<Integer> list, Integer number) {
        for (int i = 0; i < 10; i++) {
            list.add(number);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}