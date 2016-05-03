package com.example.jdm.criminalintent.model;

import java.util.UUID;

/**
 * Created by JDM on 2016/5/3.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        this.mId = UUID.randomUUID();
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
}
