package Thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new CopyOnWriteArrayList<>();
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        TestThread testThread1 = new TestThread(list, 1);
        TestThread testThread2 = new TestThread(list, 2);
        TestThread testThread3 = new TestThread(list, 3);
        TestThread testThread4 = new TestThread(list, 4);
        TestThread testThread5 = new TestThread(list, 5);

        testThread1.start();
        testThread2.start();
        testThread3.start();
        testThread4.start();
        testThread5.start();

        testThread1.join();
        testThread2.join();
        testThread3.join();
        testThread4.join();
        testThread5.join();

        long end = System.currentTimeMillis();

        System.out.println(list.size());
        System.out.println(end - start);

    }
}