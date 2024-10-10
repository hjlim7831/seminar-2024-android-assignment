package com.wafflestudio.waffleseminar2024

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.wafflestudio.waffleseminar2024.databinding.HomeTabBinding

class HomeTabActivity: AppCompatActivity() {
    private lateinit var binding: HomeTabBinding
    private lateinit var tabAdapter: TabAdapter
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val workspaceUrl = intent.getStringExtra("WORKSPACE_URL") ?: ""
        Log.d("HomeTabActivity", "Received WORKSPACE_URL: $workspaceUrl")

        val tabs = listOf(
            TabItem("영화", R.drawable.movie_recorder),
            TabItem("앱", R.drawable.app_mobile),
            TabItem("검색", R.drawable.search),
            TabItem("프로필", R.drawable.profile)
        )

        setupRecyclerView(tabs)
        setupViewPager(tabs, workspaceUrl)
    }

    private fun setupRecyclerView(tabs: List<TabItem>) {
        tabAdapter = TabAdapter(tabs) { position ->
            binding.viewPager.currentItem = position
        }
        binding.tabRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeTabActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = tabAdapter
        }
    }

    private fun setupViewPager(tabs: List<TabItem>, workspaceUrl: String) {
        Log.d("HomeTabActivity", "Setting up ViewPager with WORKSPACE_URL: $workspaceUrl")
        viewPagerAdapter = ViewPagerAdapter(tabs, workspaceUrl)
        binding.viewPager.adapter = viewPagerAdapter
    }
}
