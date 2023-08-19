package Util;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(2);
        values.add(1);
        values.add(5);

        HashSet<Integer> integers = new LinkedHashSet<>(values);

        System.out.println(integers);
    }

}
