import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        while (true) {
            System.out.println("Bạn muốn chọn chức năng nào?");
            System.out.println("1. Thêm mới nhân viên");
            System.out.println("2. Tìm kiếm nhân viên");
            System.out.println("3. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Vui lòng nhập chức vụ của nhân viên - 1. Công nhân, 2. Kỹ sư, 3. Nhân viên văn phòng");

                int position = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Vui lòng nhập tên : ");
                String name = scanner.nextLine();

                System.out.println("Vui lòng nhập tuổi :");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Vui lòng nhập giới tính : ");
                String gender = scanner.nextLine();

                System.out.println("Vui lòng nhập địa chỉ : ");
                String address = scanner.nextLine();

                switch (position) {
                    case 1:
                        System.out.println("Vui lòng nhập cấp bậc :");
                        int level = scanner.nextInt();
                        scanner.nextLine();
                        employees.add(new Labor(name, age, gender, address, level));
                        break;
                    case 2:
                        System.out.println("Vui lòng nhập chuyên ngành :");
                        String major = scanner.nextLine();
                        System.out.println("Vui lòng nhập cấp bậc :");
                        String engineerLevel = scanner.nextLine();
                        employees.add(new Engineer(name, age, gender, address, major, engineerLevel));
                        break;
                    case 3:
                        System.out.println("Vui lòng nhập số năm kinh nghiệm :");
                        int yearsOfExperience = scanner.nextInt();
                        scanner.nextLine();
                        employees.add(new Officer(name, age, gender, address, yearsOfExperience));
                        break;
                }
                System.out.println("Kết quả đã lưu thành công !");
                for (Employee employee : employees) {
                    System.out.println(employee + ", Lương : " + numberFormat.format(employee.getSalary()));
                }
            } else if (choice == 2) {
                System.out.println("Nhập từ khóa để tìm kiếm :");
                String search = scanner.nextLine();
                ArrayList<Employee> results = new ArrayList<>();
                for (Employee employee : employees) {
                    if (employee.getName().toLowerCase().contains(search.toLowerCase()) ||
                            employee.getAge() == Integer.parseInt(search) ||
                            employee.getAddress().toLowerCase().contains(search.toLowerCase())) {
                        results.add(employee);
                    }
                }
                if (results.size() == 0) {
                    System.out.println("Không tìm thấy !");
                } else {
                    for (Employee employee : results) {
                        System.out.println(employee.toString() + ", Lương : " + numberFormat.format(employee.getSalary()));
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}