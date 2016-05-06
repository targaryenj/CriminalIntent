package com.example.jdm.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.jdm.criminalintent.fragment.CrimeListFragment;

/**
 * Created by JDM on 2016/5/4.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
