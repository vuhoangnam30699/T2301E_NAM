package Generic;

public class Animal {
    private String gender;
    private Integer age;

    public Animal(String gender, Integer age) {
        this.gender = gender;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Gender : " + gender + ", age : " + age;
    }
}
