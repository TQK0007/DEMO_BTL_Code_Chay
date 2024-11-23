package com.example.pj_chay.Entity;

public class Student {
    private int student_Id;
    private String student_Name;
    private Account account;

    public Student() {}

    public Student(int student_Id, String student_Name, Account account) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.account = account;
    }

    public Student(String student_Name, Account account) {
        this.student_Name = student_Name;
        this.account = account;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_Id=" + student_Id +
                ", student_Name='" + student_Name + '\'' +
                ", account=" + account +
                '}';
    }
}
