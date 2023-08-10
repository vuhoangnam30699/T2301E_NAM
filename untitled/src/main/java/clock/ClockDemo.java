package clock;

public class ClockDemo {
    public static void main(String[] args) {

        Clock clock1 = new Clock();
//        Clock clock2 = new Clock(0,59,60);
//        clock1.addClock(clock2);
        clock1.tickDown();
        System.out.println(clock1);
    }
}
