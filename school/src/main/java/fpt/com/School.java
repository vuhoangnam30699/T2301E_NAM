package fpt.com;

public class School {
    private String schoolId;
    private String name;
    private String address;

    public School(String schoolId, String name, String address) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return schoolId + " - " + name + " - " + address;
    }
}
