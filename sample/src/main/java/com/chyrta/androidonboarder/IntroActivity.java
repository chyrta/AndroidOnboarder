package com.chyrta.androidonboarder;

import android.os.Bundle;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Description 1");
        OnboarderPage onboarderPage2 = new OnboarderPage("Title 2", "Description 2");
        OnboarderPage onboarderPage3 = new OnboarderPage("Title 1", "Description 3");

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPage1);
        pages.add(onboarderPage2);
        pages.add(onboarderPage3);

        setOnboardPages(pages);
    }
}
