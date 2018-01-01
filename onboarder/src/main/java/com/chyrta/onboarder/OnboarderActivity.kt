package com.chyrta.onboarder

import android.animation.ArgbEvaluator
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.chyrta.onboarder.utils.ColorsArrayBuilder
import com.rd.PageIndicatorView

abstract class OnboarderActivity : AppCompatActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    private var colors: Array<Int>? = null
    private var pageIndicatorView: PageIndicatorView? = null
    private var vpOnboarderPager: ViewPager? = null
    private var onboarderAdapter: OnboarderAdapter? = null
    private var evaluator: ArgbEvaluator? = null
    private var btnGetStarted: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarder)
        setStatusBackgroundColor()
        hideActionBar()
        onboarderAdapter = OnboarderAdapter(supportFragmentManager)
        btnGetStarted = findViewById<Button>(R.id.btn_get_started)
        pageIndicatorView = findViewById<PageIndicatorView>(R.id.circle_indicator_view)
        vpOnboarderPager = findViewById<ViewPager>(R.id.vp_onboarder_pager)
        vpOnboarderPager!!.addOnPageChangeListener(this)
        evaluator = ArgbEvaluator()
    }

    fun addPage(onboarderPage: OnboarderPage) {
        onboarderAdapter!!.addOnboarderPage(onboarderPage)
    }

    fun addGetStartedButton(getStartedButton: GetStartedButton) {
        btnGetStarted!!.text = getStartedButton.title
    }

    fun startOnboarding() {
        colors = ColorsArrayBuilder.getPageBackgroundColors(this, onboarderAdapter!!.pages)
        vpOnboarderPager!!.adapter = onboarderAdapter
        pageIndicatorView!!.setViewPager(vpOnboarderPager)
    }

    fun setUnselectedIndicatorColor(color: Int) {
        this.pageIndicatorView!!.unselectedColor = color
    }

    fun setSelectedIndicatorColor(color: Int) {
        this.pageIndicatorView!!.selectedColor = color
    }

    fun setStatusBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = ContextCompat.getColor(this, R.color.black_transparent)
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if (position < onboarderAdapter!!.count - 1 && position < colors!!.size - 1) {
            vpOnboarderPager!!.setBackgroundColor(evaluator!!.evaluate(positionOffset, colors!![position], colors!![position + 1]) as Int)
        } else {
            vpOnboarderPager!!.setBackgroundColor(colors!![colors!!.size - 1])
        }
    }

    override fun onPageSelected(position: Int) {
//        pageIndicatorView!!.setCurrentPage(position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    private fun hideActionBar() {
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    abstract fun onGetStartedButtonPressed()

}
