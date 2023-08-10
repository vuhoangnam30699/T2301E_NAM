package stream;

public class Student {
    private String name;
    private int age;

    private String schoolId;

    public Student(String name, int age, String schoolId) {
        this.name = name;
        this.age = age;
        this.schoolId = schoolId;
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return schoolId + " " + name + " " + age ;
    }
}
