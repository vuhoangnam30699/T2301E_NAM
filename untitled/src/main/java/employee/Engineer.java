package employee;

class Engineer extends Employee {
    private String major;
    private String level;

    public Engineer() {

    }

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

    @Override
    public double getSalary() {
        double salary = 0;
        double coefficient = 0;
        switch (major) {
            case "IT":
                salary = 10000000;
                break;
            case "Mechanics":
                salary = 9000000;
                break;
            case "Electronic":
                salary = 10500000;
                break;
            case "Civil":
                salary = 8000000;
                break;
            default:
                System.out.println("Không hợp lệ !");
                break;
        }
        switch (level) {
            case "Intern":
                coefficient = 0.5;
                break;
            case "Fresher":
                coefficient = 1;
                break;
            case "Junior":
                coefficient = 2;
                break;
            case "Senior":
                coefficient = 5;
                break;
            default:
                System.out.println("Không hợp lệ !");
                break;
        }

        return salary * coefficient;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chức vụ: Kỹ sư" + ", Ngành nghề: " + major + ", Cấp độ: " + level;
    }
}
