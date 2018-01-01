package com.chyrta.onboarder

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class OnboarderAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    internal var pages: MutableList<OnboarderPage> = mutableListOf<OnboarderPage>()

    fun addOnboarderPage(onboarderPage: OnboarderPage) {
        pages.add(onboarderPage)
    }

    override fun getItem(position: Int): Fragment {
        return OnboarderFragment.newInstance(pages[position])
    }

    override fun getCount(): Int {
        return pages.size
    }

}
