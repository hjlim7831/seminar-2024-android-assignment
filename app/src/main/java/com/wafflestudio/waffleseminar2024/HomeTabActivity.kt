package com.wafflestudio.waffleseminar2024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.wafflestudio.waffleseminar2024.databinding.HomeTabBinding

class HomeTabActivity: AppCompatActivity() {
    private lateinit var homeTabBinding: HomeTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeTabBinding = HomeTabBinding.inflate(layoutInflater)
        setContentView(homeTabBinding.root)

        val viewPager = homeTabBinding.viewPager
        val tabLayout = homeTabBinding.homeTabLayout

        val adapter = TabViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "영화"
                1 -> tab.text = "앱"
                2 -> tab.text = "검색"
                3 -> tab.text = "프로필"
            }
        }.attach()
    }
}