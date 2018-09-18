package com.aranirahan.pldproject

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.aranirahan.pldproject.FragmentOne
import com.aranirahan.pldproject.FragmentThree
import com.aranirahan.pldproject.FragmentTwo

class SampleAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentOne.newInstance()
        1 -> FragmentTwo.newInstance()
        2 -> FragmentThree.newInstance()
        else -> null
    }

    override fun getCount(): Int = 3
}