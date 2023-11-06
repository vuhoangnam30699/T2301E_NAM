package exam;

import java.util.ArrayList;

public class School {
    private String name;
    private String address;
    private ArrayList<TClass> classes = new ArrayList<>();

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

    public ArrayList<TClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<TClass> classes) {
        this.classes = classes;
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addClass(TClass cl){
        classes.add(cl);
    }

    @Override
    public String toString() {
        return name + ", " + address + " " + classes;
    }
}