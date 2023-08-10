package try_catch;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập số bị chia: ");
//        int a = sc.nextInt();
//        System.out.println("Nhập số chia: ");
//        int b = sc.nextInt();
//
//        int result;
//        try {
//            result = a / b;
//            System.out.println("Kết quả là: " + result);
//        } catch (ArithmeticException | NullPointerException e) {
//            System.out.println("Lỗi số học hoặc null rồi");
//        } catch (RuntimeException e) {
//            System.out.println("Lỗi gì đấy rồi");
//        } finally {
//            System.out.println("Finally");
//        }
//
//        System.out.println("Bên ngoài");

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số bị chia: ");
        int a = sc.nextInt();
        System.out.println("Nhập số chia: ");
        int b = sc.nextInt();

//        checkZero(b);

        try {
            int divide = divide(a, b);
        } catch (IOException e) {
            e.printStackTrace();;
        }

        System.out.println(a/b);
    }

//    private static void checkZero(int a) {
//        if (a == 0) {
//            throw new RuntimeException();
//        }
//    }
//
    private static int divide(int a, int b) throws IOException{
        return a/b;
    }
}
