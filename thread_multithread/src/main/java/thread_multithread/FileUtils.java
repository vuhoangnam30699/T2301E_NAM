package thread_multithread;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FileUtils {
    public static Integer sum(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName))
                .stream().mapToInt(Integer::valueOf)
                .sum();
    }

    public static void calculateSums(List<String> files, List<Integer> sums) {
        while (!files.isEmpty()) {
            String fileName = files.remove(0);
            try {
                sums.add(FileUtils.sum(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Integer> calculateSums(List<String> files) {
        List<Integer> sums = new ArrayList<>();
        while (!files.isEmpty()) {
            String fileName = files.remove(0);
            try {
                sums.add(FileUtils.sum(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sums;
    }
}