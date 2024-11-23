package com.example.pj_chay.DatabaseUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseInitialize {
    private DatabaseUtils databaseUtils;
    public DatabaseInitialize(Context context)
    {
        databaseUtils = new DatabaseUtils(context);
    }

    public DatabaseUtils getDatabaseUtils() {
        return databaseUtils;
    }

    public void setDatabaseUtils(DatabaseUtils databaseUtils) {
        this.databaseUtils = databaseUtils;
    }
}
