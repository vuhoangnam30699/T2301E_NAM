package stream;


public class School {
    private String schoolId;
    private int name;
    private int address;

    public School(String schoolId, int name, int address) {
        this.schoolId = schoolId;
        this.name = name;
        this.address = address;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return schoolId + "-" + name + "-" + address;
    }
}
