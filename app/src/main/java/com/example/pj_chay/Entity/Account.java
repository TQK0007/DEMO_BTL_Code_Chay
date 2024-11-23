package com.example.pj_chay.Entity;

public class Account {
    private int account_Id;
    private String account_Code;
    private String account_Password;
    public Account() {
    }
    public Account(int account_Id, String account_Code, String account_Password) {
        this.account_Id = account_Id;
        this.account_Code = account_Code;
        this.account_Password = account_Password;
    }

    public Account(String account_Code, String account_Password) {
        this.account_Code = account_Code;
        this.account_Password = account_Password;
    }

    public int getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }

    public String getAccount_Code() {
        return account_Code;
    }

    public void setAccount_Code(String account_Code) {
        this.account_Code = account_Code;
    }

    public String getAccount_Password() {
        return account_Password;
    }

    public void setAccount_Password(String account_Password) {
        this.account_Password = account_Password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_Id=" + account_Id +
                ", account_Code='" + account_Code + '\'' +
                ", account_Password=" + account_Password +
                '}';
    }
}
