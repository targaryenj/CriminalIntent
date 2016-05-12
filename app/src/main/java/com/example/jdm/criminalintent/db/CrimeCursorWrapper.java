package com.example.jdm.criminalintent.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.jdm.criminalintent.model.Crime;

/**
 * Cursor操作类
 * Created by JDM on 2016/5/10.
 */
public class CrimeCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(Crime.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(Crime.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(Crime.CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(Crime.CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(Crime.CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(uuidString,title,date,isSolved);
        crime.setmSuspect(suspect);
        return crime;
    }
}
