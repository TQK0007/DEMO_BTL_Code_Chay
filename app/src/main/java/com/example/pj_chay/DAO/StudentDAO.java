package com.example.pj_chay.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pj_chay.DTO.StudentDTO;
import com.example.pj_chay.DatabaseUtils.DatabaseInitialize;
import com.example.pj_chay.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAO extends DatabaseInitialize implements DAO<Student>{
    public StudentDAO(Context context) {
        super(context);
    }

    @Override
    public int add(Student student) {
       return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    public List<StudentDTO> getAll()
    {
        // lây ra đối tượng SQLiteDatabase để đọc dữ liệu
        SQLiteDatabase db = this.getDatabaseUtils().getReadableDatabase();
        StringBuffer sql = new StringBuffer();
        sql.append("Select account_Code, student_Name, role_Name from Account ");
        sql.append("Join Student on Account.account_Id = Student.account_Id ");
        sql.append("Join Role on Student.student_Id = Role.student_Id");
        Cursor cursor = db.rawQuery(sql.toString(),null);
        cursor.moveToFirst();

        List<StudentDTO> studentDTOList = new ArrayList<>();
        String account_Code,student_Name,role_Name;
        List<String> List_Role = new ArrayList<>();
        while (!cursor.isAfterLast())
        {
            if(studentDTOList.isEmpty())
            {
                account_Code = cursor.getString(0);
                student_Name = cursor.getString(1);
                role_Name = cursor.getString(2);
                List_Role.add(role_Name);
                StudentDTO s = new StudentDTO(account_Code,student_Name,List_Role);
                studentDTOList.add(s);
            }
            else
            {
                String finalAccount_Code = cursor.getString(0);
                Optional<StudentDTO> studentDTOOptional = studentDTOList.stream().filter(s1->s1.getAccount_Code().equals(finalAccount_Code)).findFirst();
                if(studentDTOOptional.isPresent())
                {
                    StudentDTO studentDTO = studentDTOOptional.get();
                    role_Name = cursor.getString(2);
                    List_Role.add(role_Name);
                    studentDTO.setList_Role(List_Role);
                }
                else
                {
                    account_Code = cursor.getString(0);
                    student_Name = cursor.getString(1);
                    role_Name = cursor.getString(2);
                    List<String> newList_Role = new ArrayList<>();
                    newList_Role.add(role_Name);
                    StudentDTO s = new StudentDTO(account_Code,student_Name,newList_Role);
                    studentDTOList.add(s);
                }
            }
            cursor.moveToNext();
        }
        return studentDTOList;
    }
}
