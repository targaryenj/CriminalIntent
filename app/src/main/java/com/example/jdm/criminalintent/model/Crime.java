package com.example.jdm.criminalintent.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by JDM on 2016/5/3.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
    }

    public Crime(String uuidString, String title, long date, int isSolved) {
        this.mId = UUID.fromString(uuidString);
        this.mTitle = title;
        this.mDate = new Date(date);
        this.mSolved = (isSolved != 0);
    }

    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }


    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
