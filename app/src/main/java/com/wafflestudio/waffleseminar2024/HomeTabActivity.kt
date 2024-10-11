package com.wafflestudio.waffleseminar2024

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.wafflestudio.waffleseminar2024.databinding.HomeTabBinding

class HomeTabActivity: AppCompatActivity() {
    private lateinit var binding: HomeTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val workspaceUrl = intent.getStringExtra("WORKSPACE_URL") ?: ""

        val tabs = listOf(
            TabItem("영화", R.drawable.movie_recorder) { MovieFragment() },
            TabItem("앱", R.drawable.app_mobile) { AppFragment() },
            TabItem("검색", R.drawable.search) { SearchFragment() },
            TabItem("프로필", R.drawable.profile) { ProfileFragment.newInstance(workspaceUrl) }
        )

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(this, tabs)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTabItem(position).title
            tab.icon = ContextCompat.getDrawable(this, adapter.getTabItem(position).iconResId)
        }.attach()

    }
}
