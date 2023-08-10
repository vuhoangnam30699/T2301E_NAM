package exam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.getInteger;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        sc.useDelimiter(" ");
//
//        System.out.print("Vui lòng nhập tên trường: ");
//        String name = sc.nextLine();
//        System.out.print("Vui lòng nhập địa chỉ: ");
//        String address = sc.nextLine();
//
//        School school = new School(name, address);
//        System.out.println(school);

//        loop:
//        while (true) {
//            try {
//                System.out.print("Chọn lớp chuyên: 1. Chuyên Lý - 2. Chuyên Toán - 3. Thoát ");
//                int selected = getInteger(String.valueOf(sc));
//
//                switch (selected) {
//                    case 1:
//                        System.out.print("Vui lòng nhập tên lớp: ");
//                        String name = sc.nextLine();
//                        System.out.print("Vui lòng nhập khối: ");
//                        Integer grade = sc.nextInt();
//                        PhysicsClass physicsClass = new PhysicsClass(name, grade);
//                        System.out.print(physicsClass);
//                        bank.createAccount(customerName, accountNumber, balance);
//                        bank.displayAccountDetails(accountNumber);
//                        break;
//                    case 2:
//                        System.out.print("Vui lòng nhập số tài khoản: ");
//                        String accountNumberToFind = sc.nextLine();
//                        bank.displayAccountDetails(accountNumberToFind);
//                        break;
//                    case 3:
//                        System.out.print("Vui lòng nhập số tài khoản: ");
//                        String accountNumberToWithdraw = sc.nextLine();
//                        System.out.print("Vui lòng nhập số tiền muốn rút: ");
//                        double amountToWithdraw = getDouble(sc);
//                        bank.withdraw(accountNumberToWithdraw, amountToWithdraw);
//                        bank.displayAccountDetails(accountNumberToWithdraw);
//                        break;
//                    case 4:
//                        System.out.print("Vui lòng nhập số tài khoản: ");
//                        String accountNumberToDeposit = sc.nextLine();
//                        System.out.print("Vui lòng nhập số tiền muốn nạp: ");
//                        double amountToDeposit = getDouble(sc);
//                        bank.deposit(accountNumberToDeposit, amountToDeposit);
//                        bank.displayAccountDetails(accountNumberToDeposit);
//                        break;
//                    case 5:
//                        break loop;
//                    default:
//                        System.out.println("Thao tác không tìm thấy!");
//                        break;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập giá trị số");
//            } catch (IllegalArgumentException e) {
//                System.out.println("Thông tin nhập vào không chính xác!");
//            } catch (AccountNotFoundException | BalanceNotEnoughException | ArrayIndexOutOfBoundsException e) {
//                System.out.println(e.getMessage());
//            }
//
//
//        }
//    }
//
//    private static int getInteger(Scanner scanner) {
//        String value = scanner.nextLine();
//        if (value.contains(" ")) {
//            throw new ArrayIndexOutOfBoundsException("Chỉ nập vào 1 giá trị");
//        }
//
//        return Integer.parseInt(value);
//    }
//
//    private static double getDouble(Scanner scanner) {
//        String value = scanner.nextLine();
//        if (value.contains(" ")) {
//            throw new ArrayIndexOutOfBoundsException("Chỉ nhập vào 1 giá trị");
//        }
//
//        return Double.parseDouble(value);
//    }
//}

        School school = new School("FPT Aptech", "8 Ton That Thuyet");
        MathsClass mathsClass = new MathsClass("6A", 6);
        school.addClass(mathsClass);

        Student student1 = new Student("Nguyen Binh", LocalDate.of(2012, 2, 1), "Male");
        HashMap<Subject, Double> scores1 = new HashMap<>();
        scores1.put(Subject.MATHS, 9.3);
        scores1.put(Subject.PHYSICS, 8.1);
        scores1.put(Subject.GEOGRAPHY, 7.4);
        scores1.put(Subject.HISTORY, 8.2);
        scores1.put(Subject.BIOLOGY, 6.5);
        student1.setScore(scores1);
        mathsClass.addStudents(student1);

        Student student2 = new Student("Vu Chien", LocalDate.of(2012, 6, 5), "Male");
        HashMap<Subject, Double> scores2 = new HashMap<>();
        scores2.put(Subject.MATHS, 8.3);
        scores2.put(Subject.PHYSICS, 7.1);
        scores2.put(Subject.GEOGRAPHY, 9.4);
        scores2.put(Subject.HISTORY, 9.1);
        scores2.put(Subject.BIOLOGY, 9.6);
        student2.setScore(scores2);
        mathsClass.addStudents(student2);

        Student student3 = new Student("Tran Dung", LocalDate.of(2012, 3, 4), "Female");
        HashMap<Subject, Double> scores3 = new HashMap<>();
        scores3.put(Subject.MATHS, 9.8);
        scores3.put(Subject.PHYSICS, 7.2);
        scores3.put(Subject.GEOGRAPHY, 9.1);
        scores3.put(Subject.HISTORY, 7.2);
        scores3.put(Subject.BIOLOGY, 7.5);
        student3.setScore(scores3);
        mathsClass.addStudents(student3);

        Student student4 = new Student("Hoang Dat", LocalDate.of(2012, 9, 2), "Male");
        HashMap<Subject, Double> scores4 = new HashMap<>();
        scores4.put(Subject.MATHS, 9.1);
        scores4.put(Subject.PHYSICS, 9.0);
        scores4.put(Subject.GEOGRAPHY, 6.4);
        scores4.put(Subject.HISTORY, 6.8);
        scores4.put(Subject.BIOLOGY, 7.9);
        student4.setScore(scores4);
        mathsClass.addStudents(student4);

        Student student5 = new Student("Dang Trang", LocalDate.of(2012,12 ,11), "Female");
        HashMap<Subject, Double> scores5 = new HashMap<>();
        scores5.put(Subject.MATHS, 6.3);
        scores5.put(Subject.PHYSICS, 9.5);
        scores5.put(Subject.GEOGRAPHY, 8.0);
        scores5.put(Subject.HISTORY, 8.2);
        scores5.put(Subject.BIOLOGY, 8.3);
        student5.setScore(scores5);
        mathsClass.addStudents(student5);


        System.out.println(school);
        for (Student student: mathsClass.getStudents()) {
            System.out.println(student);
        }
        System.out.println("Điểm trung bình của lớp " + mathsClass.getName() + ": " + mathsClass.averageScore());

    }
}