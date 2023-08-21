package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        Job job1 = new Job(1, list);
        Job job2 = new Job(2, list);
        job1.start();
        job2.start();

        System.out.println("Start");

        job1.join();
        job2.join();

        System.out.println(list);
        System.out.println(list.size());


    }
}
