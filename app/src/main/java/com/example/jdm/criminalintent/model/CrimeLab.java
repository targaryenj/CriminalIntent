package com.example.jdm.criminalintent.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jdm.criminalintent.db.CrimeBaseHelper;
import com.example.jdm.criminalintent.db.CrimeCursorWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by JDM on 2016/5/4.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
    }


    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(Crime.CrimeTable.Cols.UUID, crime.getmId().toString());
        values.put(Crime.CrimeTable.Cols.TITLE, crime.getmTitle());
        values.put(Crime.CrimeTable.Cols.DATE, crime.getmDate().getTime());
        values.put(Crime.CrimeTable.Cols.SOLVED, crime.ismSolved() ? 1:0);
        return values;
    }

    /**
     * 增加Crime
     * @param c
     */
    public void addCrime(Crime c){
        ContentValues values = getContentValues(c);
        mDatabase.insert(Crime.CrimeTable.NAME,null,values);
    }

    /**
     * 更新
     * @param c
     */
    public void updateCrime(Crime c){
        String uuidString = c.getmId().toString();
        ContentValues values = getContentValues(c);
        mDatabase.update(Crime.CrimeTable.NAME, values, Crime.CrimeTable.Cols.UUID + " = ?",new String[] {uuidString});
    }


    private CrimeCursorWrapper queryCrimesWrapper(String whereCaluse, String [] whereArgs){
        Cursor cursor = mDatabase.query(Crime.CrimeTable.NAME,
                null,
                whereCaluse,
                whereArgs,
                null,
                null,
                null);
        return new CrimeCursorWrapper(cursor);
    }

    /**
     * 查询Crimes
     * @return
     */
    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        CrimeCursorWrapper cursor = queryCrimesWrapper(null,null);
        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return crimes;
    }

    /**
     * 查询指定id的Crime
     * @param id
     * @return
     */
    public Crime getCrime(UUID id){
        CrimeCursorWrapper cursor = queryCrimesWrapper(Crime.CrimeTable.Cols.UUID + " = ?" ,new String[]{id.toString()});
        try{
            if (cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCrime();
        }finally {
            cursor.close();
        }
    }

    private Cursor queryCrimes(String whereCaluse,String [] whereArgs){
        Cursor cursor = mDatabase.query(Crime.CrimeTable.NAME,
                null,
                whereCaluse,
                whereArgs,
                null,
                null,
                null);
        return cursor;
    }


}
