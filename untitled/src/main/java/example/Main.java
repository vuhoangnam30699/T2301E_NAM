package example;


class Transport {
        protected void Name() {
            System.out.println("Name");
    }
}

    class Car extends Transport {
        protected void Name() {
            System.out.println("Honda");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.Name();


        Dog myDog = new Dog();
        myDog.setAge(2);
        myDog.setMale(false);
        myDog.setName("Milo");
        final int a = 10; // Local variable

        System.out.println("Legs : " + Dog.legs);
        System.out.println("Legs : " + myDog.legs);
        System.out.println(a);



        Dog dog1 = new Dog();
        dog1.setName("dog1");
        Dog dog2 = dog1;
        System.out.println(dog2.getName());
        dog1.setName("dog 1 update");
        System.out.println(dog2.getName());



//        Scanner input = new Scanner(System.in);
//        System.out.print("Nhap so tu nhien thu 1 : ");
//        int so1 = input.nextInt();
//        System.out.print("Nhap so tu nhien thu 2 : ");
//        int so2 = input.nextInt();
//        System.out.println("Tich 2 so da nhap la : " + so1 * so2);

        Dog dog = new Dog();
        dog.eat("banh mi", "kem", "xoi");

//        double c = 10.9;
//        int d = (int) c;
//        System.out.println(d);

        for(int i = 0; i < 10; i++) {
            if (i == 7) {
                continue;
            }
            System.out.println(i);
        }

        int g = 6;
        switch (g) {
            case 1 :
                System.out.println("1");
                break;
            case 2 :
                System.out.println("2");
                break;
            case 3 :
                System.out.println("3");
                break;
            case 4 :
                System.out.println("4");
                break;
            case 5 :
                System.out.println("5");
                break;
            default :
                System.out.println("het");
        }

        Human human1 = new Human(10, "Alice");
        Human human2 = new Human(20, "Bob");
        Human human3 = new Human(30, "Chris");
        Human human4 = new Human(40, "Dan");
        Human human5 = new Human(40, "Elsa");


        Human[] humans = {human1, human2, human3, human4, human5};

        // 1. Find name of the person who is oldest
        // 2. Find name of all person who are oldest


        Human oldestHuman = new Human();
        int count = 0;
        for (Human human : humans) {
            if (human.getAge() > oldestHuman.getAge()) {
                oldestHuman = human;
                count = human.getAge();
            }
        }
        for (Human human : humans) {
            if (human.getAge() == count) {
                System.out.println(human.getName());
            }
        }


    }
}