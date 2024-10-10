package com.wafflestudio.waffleseminar2024

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.waffleseminar2024.databinding.ItemTabBinding

class TabAdapter(
    private val tabs: List<TabItem>,
    private val onTabClick: (Int) -> Unit
): RecyclerView.Adapter<TabAdapter.TabViewHolder>() {

    private var selectedPosition = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TabViewHolder {
        val binding = ItemTabBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TabViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        val tab = tabs[position]
        holder.bind(tab, position == selectedPosition)
        holder.itemView.setOnClickListener { onTabClick(position) }
    }

    override fun getItemCount(): Int = tabs.size


    fun updateSelectedTab(position: Int) {
        val previousPosition = selectedPosition
        selectedPosition = position
        notifyItemChanged(previousPosition)
        notifyItemChanged(selectedPosition)
    }

    class TabViewHolder(private val binding: ItemTabBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tab: TabItem, isSelected: Boolean) {
            binding.tabIcon.setImageResource(tab.iconResId)
            binding.tabTitle.text = tab.title
            itemView.isSelected = isSelected
        }
    }

}