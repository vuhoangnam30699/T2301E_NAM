package jdbc;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Date dob;

    public Student(Integer id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return  "\nId:      " + id +
                "\nName:    " + name +
                "\nDoB:     " + dob +
                "\n";
    }
}

