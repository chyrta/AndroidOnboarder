package com.chyrta.androidonboarder;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chyrta.onboarder.GetStartedButton;
import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

public class IntroActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPage(OnboarderPage.Companion.newCreator()
                    .title("Planet Earth")
                    .description("Our lovely pale blue dot")
                    .backgroundColor(R.color.onboarder_bg_1)
                    .imageResourceId(R.drawable.planet1)
                    .create());
        addPage(OnboarderPage.Companion.newCreator()
                    .title("Venus")
                    .description("The love goddess")
                    .backgroundColor(R.color.onboarder_bg_2)
                    .imageResourceId(R.drawable.planet2)
                    .create());
        addPage(OnboarderPage.Companion.newCreator()
                    .title("Mars")
                    .description("Say hi to Curiosity")
                    .backgroundColor(R.color.onboarder_bg_3)
                    .imageResourceId(R.drawable.planet3)
                    .create());
        addGetStartedButton(GetStartedButton.Companion.newCreator()
                    .text("Get started")
                    .textColor(android.R.color.black)
                    .create());
        startOnboarding();

    }

    @Override
    public void onGetStartedButtonPressed() {
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {

    }

}
