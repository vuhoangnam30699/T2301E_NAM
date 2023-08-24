package thread_multithread;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class FileSumThread extends Thread {
    private List<String> files;
    private List<Integer> sums;

    @Override
    public void run() {
        FileUtils.calculateSums(files, sums);

    }
}