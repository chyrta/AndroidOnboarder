package com.chyrta.onboarder;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class OnboarderActivity extends AppCompatActivity {

    ViewPager vpOnboarderPager;
    OnboarderAdapter onboarderAdapter;

    public interface OnOnboarderPageClickListener {
        void onClick(int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarder);
    }

    public void setOnboardPages(List<OnboarderPage> pages) {
        onboarderAdapter = new OnboarderAdapter(pages, getSupportFragmentManager());
        vpOnboarderPager.setAdapter(onboarderAdapter);
    }

}
