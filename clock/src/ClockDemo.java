public class ClockDemo {
    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59, 60);
        System.out.println(clock1);
        clock1.tickDown();
        System.out.println(clock1);
        Clock clock2 = new Clock(11,59,60);
        clock1.addClock(clock2);
        System.out.println(clock1);
    }
}
