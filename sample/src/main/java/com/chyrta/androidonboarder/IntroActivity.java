package com.chyrta.androidonboarder;

import android.os.Bundle;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderAdapter;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Title 2", R.drawable.ic_chevron_right);
        onboarderPage1.setTitleColor(R.color.colorPrimary);
        onboarderPage1.setDescriptionColor(R.color.colorAccent);
        OnboarderPage onboarderPage2 = new OnboarderPage("Title 2", "Description 2");
        onboarderPage2.setTitleColor(R.color.colorPrimaryDark);
        onboarderPage2.setDescriptionColor(R.color.colorAccent);
        OnboarderPage onboarderPage3 = new OnboarderPage("Title 3", "Description 3");
//        onboarderPage3.setTitleColor(R.color.colorPrimaryDark);
//        onboarderPage3.setDescriptionColor(R.color.colorAccent);

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPage1);
        pages.add(onboarderPage2);
        pages.add(onboarderPage3);

        setOnboardPagesReady(pages);

    }
}
