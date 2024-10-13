package com.wafflestudio.waffleseminar2024.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.waffleseminar2024.databinding.ItemSearchGenreButtonBinding
import com.wafflestudio.waffleseminar2024.databinding.ItemSearchLabelBinding

class SearchItemAdapter(
    private val items: List<SearchItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_LABEL = 0
        private const val TYPE_GENRE_BUTTON = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is SearchItem.Label -> TYPE_LABEL
            is SearchItem.GenreButton -> TYPE_GENRE_BUTTON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_LABEL -> {
                val binding = ItemSearchLabelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LabelViewHolder(binding)
            }
            TYPE_GENRE_BUTTON -> {
                val binding = ItemSearchGenreButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                GenreButtonViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is SearchItem.Label -> (holder as LabelViewHolder).bind(item)
            is SearchItem.GenreButton -> (holder as GenreButtonViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    class LabelViewHolder(private val binding: ItemSearchLabelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(label: SearchItem.Label) {
            binding.root.text = label.name
        }
    }

    class GenreButtonViewHolder(private val binding: ItemSearchGenreButtonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(genreButton: SearchItem.GenreButton) {
            binding.genreName.text = genreButton.name
            binding.genreIcon.setImageResource(genreButton.iconResId)
        }
    }
}
