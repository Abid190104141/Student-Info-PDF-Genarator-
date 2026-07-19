package org.example.firstapplication;

public class Student {

    private int id;
    private String name;
    private String dept;
    private String email;

    public Student(int id, String name, String dept, String email) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getEmail() {
        return email;
    }
}