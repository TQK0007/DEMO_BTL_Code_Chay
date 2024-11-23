package com.example.pj_chay.Entity;

public class Role {
    private int role_Id;
    private String role_Name;
    private Student student;

    public Role(){}

    public Role(int role_Id, String role_Name, Student student) {
        this.role_Id = role_Id;
        this.role_Name = role_Name;
        this.student = student;
    }

    public Role(String role_Name, Student student) {
        this.role_Name = role_Name;
        this.student = student;
    }

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(String role_Name) {
        this.role_Name = role_Name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_Id=" + role_Id +
                ", role_Name='" + role_Name + '\'' +
                ", student=" + student +
                '}';
    }
}
