package Generic;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("male", 2);
        Cat cat = new Cat("female", 1);
//        Animal older = findOlder(dog, cat);
//        System.out.println(older);
        Pair<Dog, Cat> pair = new Pair<>(dog, cat);
        System.out.println(pair);

    }

    public static <T extends Animal> void printOldest(List<? extends Animal> animals) {
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
    }

//    private static void print1(List<?> list) {
//        list.forEach();
//    }
}
