package com.chyrta.androidonboarder;

import android.os.Bundle;
import android.widget.Toast;

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
        OnboarderPage onboarderPage2 = new OnboarderPage("Title 2", "Description 2");
        OnboarderPage onboarderPage3 = new OnboarderPage("Title 3", "Description 3");
        OnboarderPage onboarderPage4 = new OnboarderPage("Title 4", "Description 4");
        onboarderPage4.setTitleColor(R.color.colorPrimaryDark);
        onboarderPage4.setDescriptionColor(R.color.colorAccent);
        onboarderPage4.setBackgroundColor(R.color.colorPrimaryDark);

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPage1);
        pages.add(onboarderPage2);
        pages.add(onboarderPage3);
        pages.add(onboarderPage4);

        setOnboardPagesReady(pages);

    }

    @Override
    public void onSkipButtonPressed() {
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
    }

}
