package com.example.jdm.criminalintent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jdm.criminalintent.model.Crime;

/**
 * SQLite操作帮助类
 * Created by JDM on 2016/5/10.
 */
public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    /**
     * 创建表
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Crime.CrimeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                Crime.CrimeTable.Cols.UUID + ", " +
                Crime.CrimeTable.Cols.TITLE + "," +
                Crime.CrimeTable.Cols.DATE + ", " +
                Crime.CrimeTable.Cols.SOLVED + ", " +
                Crime.CrimeTable.Cols.SUSPECT + ")");
    }

    /**
     * 更新数据库
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
