package Thread;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@AllArgsConstructor
public class TestThread extends Thread {
    private final List<Integer> list;
    private final Integer number;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                list.add(number);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
