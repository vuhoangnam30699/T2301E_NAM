package Generic;

public class Dog extends Animal{

    public Dog(String gender, Integer age) {
        super(gender, age);
    }

    @Override
    public String toString() {
        return "Dog, " + super.toString();
    }
}
