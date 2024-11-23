package com.example.pj_chay.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pj_chay.DatabaseUtils.DatabaseInitialize;
import com.example.pj_chay.DatabaseUtils.DatabaseUtils;
import com.example.pj_chay.Entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DatabaseInitialize implements DAO<Account> {

    private final String TABLE_NAME="Account";
    public AccountDAO(Context context) {
        super(context);

    }
    @Override
    public int add(Account account) {
        ContentValues values = new ContentValues();
        values.put("account_Code",account.getAccount_Code());
        values.put("account_Password",account.getAccount_Password());
        DatabaseUtils dbU = this.getDatabaseUtils();
        SQLiteDatabase db = dbU.getWritableDatabase();

        if(db.insert(TABLE_NAME,null,values)<0) return -1;
        return 1;
    }
    @Override
    public int update(Account account) {
        ContentValues values = new ContentValues();
        values.put("account_Code",account.getAccount_Code());
        values.put("account_Password",account.getAccount_Password());
        SQLiteDatabase db = this.getDatabaseUtils().getWritableDatabase();
        if(db.update(TABLE_NAME,values,"account_Id=?",new String[]{String.valueOf(account.getAccount_Id())})<0) return -1;
        return 1;
    }
    @Override
    public int delete(Account account) {
        SQLiteDatabase db = this.getDatabaseUtils().getWritableDatabase();
        if(db.delete(TABLE_NAME,"account_Code=?",new String[] {account.getAccount_Code()})<0) return -1;
        return 1;
    }
    public List<Account> getALL()
    {
        List<Account> accountList = new ArrayList<>();
        SQLiteDatabase db = this.getDatabaseUtils().getReadableDatabase();
        StringBuffer sql = new StringBuffer();
        sql.append("Select * from Account ");
        Cursor cursor = db.rawQuery(sql.toString(),null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int account_Id = cursor.getInt(0);
            String account_Code = cursor.getString(1);
            String account_Password = cursor.getString(2);
            Account account = new Account(account_Id,account_Code,account_Password);
            accountList.add(account);
            cursor.moveToNext();
        }
        db.close();
        return accountList;
    }
}
