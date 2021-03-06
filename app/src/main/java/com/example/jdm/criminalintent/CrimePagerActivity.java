package com.example.jdm.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jdm.criminalintent.fragment.CrimeFragment;
import com.example.jdm.criminalintent.model.Crime;
import com.example.jdm.criminalintent.model.CrimeLab;

import java.util.List;
import java.util.UUID;

/**
 * Created by JDM on 2016/5/5.
 */
public class CrimePagerActivity extends AppCompatActivity implements CrimeFragment.Callbacks{

    private static final String EXTRA_CRIME_ID = "com.criminalintent.crime_id";
    private static final String TAG = "CrimePagerActivity";

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext,CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }


    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);


        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Crime crime = mCrimes.get(position);
                Log.d(TAG,"action bar =" + getSupportActionBar());
                if (getSupportActionBar() != null){
                    getSupportActionBar().setTitle(crime.getmTitle());
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        for (int i = 0;i < mCrimes.size(); i++){
            if (mCrimes.get(i).getmId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }

    @Override
    public void onCrimeUpdate(Crime crime) {

    }
}
