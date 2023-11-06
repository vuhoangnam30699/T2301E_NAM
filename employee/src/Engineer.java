public class Engineer extends Employee {
    private String major;
    private  String level;

    public Engineer(String name, int age, String gender, String address, String major, String level) {
        super(name, age, gender, address);
        this.major = major;
        this.level = level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getSalary() {
        double baseSalary = 0;
        double factor = 0;

        switch (major) {
            case "IT":
                baseSalary = 10000000;
                break;
            case "Mechanics":
                baseSalary = 9000000;
                break;
            case "Electronics":
                baseSalary = 10500000;
                break;
            case "Civil":
                baseSalary = 8000000;
                break;
            default:
                System.out.println("Không hợp lệ !");
                break;
        }

        switch (level) {
            case "Intern":
                factor = 0.5;
                break;
            case "Fresher":
                factor = 1;
                break;
            case "Junior":
                factor = 2;
                break;
            case "Senior":
                factor = 5;
                break;
            default:
                System.out.println("Không hợp lệ !");
                break;
        }
        return baseSalary * factor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chức vụ: Kỹ sư" + ", Chuyên ngành: " + major + ", Cấp độ: " + level;
    }
}
