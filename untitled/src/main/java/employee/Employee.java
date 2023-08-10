package employee;

public class Employee {
    String name;
    private int age;
    private String gender;
    private String address;


    public Employee() {

    }

    public Employee(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return " Họ và tên: " + name + ", Tuổi: " + age + ", Giới tính: " + gender + ", Địa chỉ: " + address;
    }
}
