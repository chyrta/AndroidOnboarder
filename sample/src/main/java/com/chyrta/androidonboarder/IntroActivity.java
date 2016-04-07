package com.chyrta.androidonboarder;

import android.os.Bundle;
import android.widget.Toast;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboarderPage onboarderPage1 = new OnboarderPage("Planet Earth", "Our lovely pale blue dot", R.drawable.planet1);
        OnboarderPage onboarderPage2 = new OnboarderPage("Venus", "The love goddess", R.drawable.planet2);
        OnboarderPage onboarderPage3 = new OnboarderPage("Mars", "Say hi to Curiosity!", R.drawable.planet3);

        onboarderPage1.setBackgroundColor(R.color.onboarder_bg_1);
        onboarderPage2.setBackgroundColor(R.color.onboarder_bg_2);
        onboarderPage3.setBackgroundColor(R.color.onboarder_bg_3);

        List<OnboarderPage> pages = new ArrayList<>();

        pages.add(onboarderPage1);
        pages.add(onboarderPage2);
        pages.add(onboarderPage3);

        for (OnboarderPage page : pages) {
            page.setTitleColor(R.color.primary_text);
            page.setDescriptionColor(R.color.secondary_text);
        }

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
