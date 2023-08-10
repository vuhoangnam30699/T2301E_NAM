package example;
// private  --> trong class
// public   --> mọi nơi


public class Dog {
    private String name; // Instance variable
    private int age;
    private boolean isMale; //true - male, false - female
    public static int legs = 4; // Static variable

    private void sleep() {

    }

    public String bark() {
        return "Woof Woof!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Dog() {
//        this.legs = legs;
    }

    public Dog(String name, int age, boolean isMale, int legs) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.legs = legs;
    }

    public void eat() {
        sleep();
    }

    //Overloading
    public void eat(String food) {

    }

    public void eat(Dog food) {

    }

    public void eat(int food1, String food2) {

    }
    public void eat(String ... foods) {
        for(int i = 0; i < foods.length; i++) {
            System.out.println(foods[i]);
        }
    }

}