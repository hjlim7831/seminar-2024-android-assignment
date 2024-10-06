package com.wafflestudio.waffleseminar2024

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TabViewPagerAdapter(private val context: Context): RecyclerView.Adapter<TabViewPagerAdapter.ViewHolder>() {

    private val layouts = listOf(
        R.layout.tab_movie_view,
        R.layout.tab_app_view,
        R.layout.tab_search_view,
        R.layout.tab_profile_view
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(layouts[viewType], parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 각 탭에서 보여줄 내용 처리
    }

    override fun getItemCount(): Int = layouts.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}