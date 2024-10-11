package com.wafflestudio.waffleseminar2024

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val tabs: List<TabItem>,
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = tabs.size
    override fun createFragment(position: Int): Fragment {
        return getTabItem(position).fragmentProvider()
    }

    fun getTabItem(position: Int): TabItem {
        return tabs[position]
    }
}