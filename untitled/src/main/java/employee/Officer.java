package employee;

class Officer extends Employee {
    private int yearsOfExperience;

    public Officer() {

    }

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

    @Override
    public double getSalary() {
        double salary = 0;
        switch (yearsOfExperience) {
            case 0:
            case 1:
            case 2:
                salary = 8000000;
                break;
            case 3:
            case 4:
            case 5:
                salary = 15000000;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                salary = 25000000;
                break;
            default:
                salary = 35000000;
                break;
        }
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chức vụ: Nhân viên văn phòng" + ", Số năm kinh nghiệm: " + yearsOfExperience;
    }
}
