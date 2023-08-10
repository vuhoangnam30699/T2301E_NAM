package employee;

public class Labor extends Employee {
    private int level;

    public Labor() {

    }

    public Labor(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public double getSalary() {
        return level * 5000000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chức vụ: Công nhân" + ", Cấp: " + level;
    }
}
