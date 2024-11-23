package com.example.pj_chay.DTO;

import java.util.List;

public class StudentDTO {
    private String account_Code;
    private String student_Name;
    private List<String> list_Role;

    public StudentDTO() {
    }

    public StudentDTO(String account_Code, String student_Name, List<String> list_Role) {
        this.account_Code = account_Code;
        this.student_Name = student_Name;
        this.list_Role = list_Role;
    }

    public String getAccount_Code() {
        return account_Code;
    }

    public void setAccount_Code(String account_Code) {
        this.account_Code = account_Code;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public List<String> getList_Role() {
        return list_Role;
    }

    public void setList_Role(List<String> list_Role) {
        this.list_Role = list_Role;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "account_Code='" + account_Code + '\'' +
                ", student_Name='" + student_Name + '\'' +
                ", list_Role=" + list_Role +
                '}';
    }
}
