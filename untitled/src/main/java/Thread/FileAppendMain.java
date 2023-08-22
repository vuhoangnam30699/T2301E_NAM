package Thread;

public class FileAppendMain {
    public static void main(String[] args) {
        AppendThread thread1 = new AppendThread("test.txt", "this is from thread 1");
        AppendThread thread2 = new AppendThread("test.txt", "this is from thread 2");

        thread1.start();
        thread2.start();

    }
}