package com.example.pj_chay.DatabaseUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// lớp SQLiteOpenHelper dùng để quản lý csdl ( tạo , mở .. )
public class DatabaseUtils extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentManager.db";
    private static final int DATABASE_VERSION = 1;

    // Tạo bảng Account
    private final String CREATE_ACCOUNT_TABLE = "CREATE TABLE Account (" +
            "account_Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "account_Code TEXT, " +
            "account_Password TEXT);";

    // Tạo bảng Student
    private final String CREATE_STUDENT_TABLE = "CREATE TABLE Student (" +
            "student_Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "student_Name TEXT, " +
            "account_Id INTEGER, " +
            "FOREIGN KEY(account_Id) REFERENCES Account(account_Id) ON DELETE CASCADE);";

    // Tạo bảng Role
    private final String CREATE_ROLE_TABLE = "CREATE TABLE Role (" +
            "role_Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "role_Name TEXT, " +
            "student_Id INTEGER, " +
            "FOREIGN KEY(student_Id) REFERENCES Student(student_Id) ON DELETE CASCADE);";

    public DatabaseUtils(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ACCOUNT_TABLE);
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
        sqLiteDatabase.execSQL(CREATE_ROLE_TABLE);
            // Thêm vào bảng Account
            String insertAccount1 = "INSERT INTO Account (account_Code, account_Password) VALUES ('ACC001', 'password1');";
            String insertAccount2 = "INSERT INTO Account (account_Code, account_Password) VALUES ('ACC002', 'password2');";
// Thêm vào bảng Student
            String insertStudent1 = "INSERT INTO Student (student_Name, account_Id) VALUES ('Student 1', 1);";
            String insertStudent2 = "INSERT INTO Student (student_Name, account_Id) VALUES ('Student 2', 2);";
// Thêm vào bảng Role
            String insertRole1 = "INSERT INTO Role (role_Name, student_Id) VALUES ('Role 1', 1);";
            String insertRole2 = "INSERT INTO Role (role_Name, student_Id) VALUES ('Role 2', 1);";
            String insertRole3 = "INSERT INTO Role (role_Name, student_Id) VALUES ('Role 3', 2);";
// Thực thi các câu lệnh bằng execSQL
        sqLiteDatabase.execSQL(insertAccount1);
        sqLiteDatabase.execSQL(insertAccount2);
        sqLiteDatabase.execSQL(insertStudent1);
        sqLiteDatabase.execSQL(insertStudent2);
        sqLiteDatabase.execSQL(insertRole1);
        sqLiteDatabase.execSQL(insertRole2);
        sqLiteDatabase.execSQL(insertRole3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Role");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Student");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Account");
        onCreate(sqLiteDatabase);
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON;");
    }
}
