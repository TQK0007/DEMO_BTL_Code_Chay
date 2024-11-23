package com.example.pj_chay;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pj_chay.DAO.AccountDAO;
import com.example.pj_chay.DAO.StudentDAO;
import com.example.pj_chay.DTO.StudentDTO;
import com.example.pj_chay.Entity.Account;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentDAO studentDAO;
    private AccountDAO accountDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        studentDAO = new StudentDAO(this);
        accountDAO = new AccountDAO(this);
//        DisplayInformation();

//        addAccount();

//        updateAccount();

        DisplayInformationAccount();
        deleteAccount();
    }

//    private void DisplayInformation()
//    {
//        List<StudentDTO> li = studentDAO.getAll();
//        System.out.println("Number of list: "+li.size());
//        li.forEach(s-> System.out.println(s.toString()));
//    }


//    private void addAccount()
//    {
//        Account account = new Account("123","456");
//        if(accountDAO.add(account) > 0) System.out.println("Add account is sucessfully");
//        else System.out.println("Add account is falid");
//    }


//    private void updateAccount()
//    {
//        Account account = new Account(3,"ACC003","password3");
//        if(accountDAO.update(account) > 0) System.out.println("Update account is sucessfully");
//        else System.out.println("Update account is falid");
//    }

    private void deleteAccount()
    {
        Account account = new Account("ACC003","password3");
        if(accountDAO.delete(account) > 0) {
            System.out.println("Delete account is sucessfully");
            DisplayInformationAccount();
        }
        else System.out.println("Delete account is falid");
    }

    private void DisplayInformationAccount()
    {
        List<Account> li = accountDAO.getALL();
        System.out.println("Number of list: "+li.size());
        li.forEach(s-> System.out.println(s.toString()));
    }

}