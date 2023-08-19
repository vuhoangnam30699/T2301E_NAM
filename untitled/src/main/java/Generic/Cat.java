package Generic;

public class Cat extends Animal {

    public Cat(String gender, Integer age) {
        super(gender, age);
    }

    @Override
    public String toString() {
        return "Cat, " + super.toString();
    }
}
