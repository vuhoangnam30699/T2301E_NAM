package Thread;

public class FileAppendMain {
    public static void main(String[] args) {
        AppendThread thread1 = new AppendThread("C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\main\\java\\Thread\\test.txt", "1");
        AppendThread thread2 = new AppendThread("C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\main\\java\\Thread\\test.txt", "2");

        thread1.start();
        thread2.start();
    }
}
