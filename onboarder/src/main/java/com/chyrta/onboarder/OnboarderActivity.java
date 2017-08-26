package com.chyrta.onboarder;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chyrta.onboarder.utils.ColorsArrayBuilder;
import com.chyrta.onboarder.views.CircleIndicatorView;

public abstract class OnboarderActivity extends AppCompatActivity implements
        View.OnClickListener,
        ViewPager.OnPageChangeListener {

    private Integer[] colors;
    private CircleIndicatorView circleIndicatorView;
    private ViewPager vpOnboarderPager;
    private OnboarderAdapter onboarderAdapter;
    private ArgbEvaluator evaluator;
    private Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarder);
        setStatusBackgroundColor();
        hideActionBar();
        onboarderAdapter = new OnboarderAdapter(getSupportFragmentManager());
        btnGetStarted = findViewById(R.id.btn_get_started);
        circleIndicatorView = findViewById(R.id.circle_indicator_view);
        vpOnboarderPager = findViewById(R.id.vp_onboarder_pager);
        vpOnboarderPager.addOnPageChangeListener(this);
        evaluator = new ArgbEvaluator();
    }

    public void addPage(OnboarderPage onboarderPage) {
        onboarderAdapter.addOnboarderPage(onboarderPage);
    }

    public void addGetStartedButton(GetStartedButton getStartedButton) {
        // TODO
    }

    public void startOnboarding() {
        vpOnboarderPager.setAdapter(onboarderAdapter);
        colors = ColorsArrayBuilder.getPageBackgroundColors(this, onboarderAdapter.pages);
        circleIndicatorView.setPageIndicators(onboarderAdapter.pages.size());
    }

    public void setInactiveIndicatorColor(int color) {
        this.circleIndicatorView.setInactiveIndicatorColor(color);
    }

    public void setActiveIndicatorColor(int color) {
        this.circleIndicatorView.setActiveIndicatorColor(color);
    }

    public void setStatusBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_transparent));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(position < (onboarderAdapter.getCount() - 1) && position < (colors.length - 1)) {
            vpOnboarderPager.setBackgroundColor((Integer) evaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
        } else {
            vpOnboarderPager.setBackgroundColor(colors[colors.length - 1]);
        }
    }

    @Override
    public void onPageSelected(int position) {
        circleIndicatorView.setCurrentPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    abstract public void onGetStartedButtonPressed();

}
