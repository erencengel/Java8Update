package day1_generic.students;

import java.util.ArrayList;
import java.util.List;

public class Batch<B extends Student> {

    private String name;
    private List<B> studentsList;

    public Batch(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<B> getStudentsList() {
        return studentsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(B student){
        studentsList.add(student);
    }
}
