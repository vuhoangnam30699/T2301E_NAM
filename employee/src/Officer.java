public class Officer extends Employee {
    private int yearsOfExperience;

    public Officer(String name, int age, String gender, String address, int yearsOfExperience) {
        super(name, age, gender, address);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSalary() {
        double salary;
        if (0 < yearsOfExperience && yearsOfExperience <= 2){
            salary = 8000000;
        } else if (2 < yearsOfExperience && yearsOfExperience <= 5) {
            salary = 15000000;
        } else if (6 < yearsOfExperience && yearsOfExperience <= 10) {
            salary = 25000000;
        } else {
            salary = 35000000;
        }
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chức vụ: Nhân viên văn phòng" + ", Số năm kinh nghiệm: " + yearsOfExperience;
    }
}
