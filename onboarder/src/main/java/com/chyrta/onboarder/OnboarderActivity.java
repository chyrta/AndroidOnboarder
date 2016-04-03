package com.chyrta.onboarder;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.chyrta.onboarder.utils.ColorsArrayBuilder;
import com.chyrta.onboarder.views.CircleIndicatorView;

import java.util.List;

public class OnboarderActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Integer[] colors;
    private LinearLayout llIndicators;
    private ViewPager vpOnboarderPager;
    private OnboarderAdapter onboarderAdapter;
    private ImageButton ibNext;
    private Button btnSkip, btnFinish;
    private ArgbEvaluator evaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarder);
        setStatusBackgroundColor();

        getSupportActionBar().hide();

        llIndicators = (LinearLayout) findViewById(R.id.ll_indicators);
        ibNext = (ImageButton) findViewById(R.id.ib_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnFinish = (Button) findViewById(R.id.btn_finish);
        vpOnboarderPager = (ViewPager) findViewById(R.id.vp_onboarder_pager);
        vpOnboarderPager.addOnPageChangeListener(this);
        ibNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        evaluator = new ArgbEvaluator();
    }

    public void setOnboardPagesReady(List<OnboarderPage> pages) {
        onboarderAdapter = new OnboarderAdapter(pages, getSupportFragmentManager());
        vpOnboarderPager.setAdapter(onboarderAdapter);
        setPageIndicators(pages.size());
        colors = ColorsArrayBuilder.getPageBackgroundColors(this, pages);
    }

    public void setPageIndicators(int quantity) {
        for (int i = 0; i < quantity; i++) {
            llIndicators.addView(new CircleIndicatorView(this));
        }
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
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ib_next) {
            vpOnboarderPager.setCurrentItem(vpOnboarderPager.getCurrentItem() + 1);
        } else if (i == R.id.btn_skip) {
            vpOnboarderPager.setCurrentItem(onboarderAdapter.getCount());
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
        int lastPagePosition = onboarderAdapter.getCount() - 1;
        ibNext.setVisibility(position == lastPagePosition ? View.GONE : View.VISIBLE);
        btnFinish.setVisibility(position == lastPagePosition ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
