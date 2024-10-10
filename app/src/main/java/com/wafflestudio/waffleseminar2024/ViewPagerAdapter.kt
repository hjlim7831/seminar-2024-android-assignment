package com.wafflestudio.waffleseminar2024

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.wafflestudio.waffleseminar2024.databinding.TabAppViewBinding
import com.wafflestudio.waffleseminar2024.databinding.TabMovieViewBinding
import com.wafflestudio.waffleseminar2024.databinding.TabProfileViewBinding
import com.wafflestudio.waffleseminar2024.databinding.TabSearchViewBinding

class ViewPagerAdapter(
    private val tabs: List<TabItem>,
    private val workspaceUrl: String
) : RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    init {
        Log.d("ViewPagerAdapter", "Initialized with WORKSPACE_URL: $workspaceUrl")
    }


    companion object {
        private const val VIEW_TYPE_MOVIE = 0
        private const val VIEW_TYPE_APP = 1
        private const val VIEW_TYPE_SEARCH = 2
        private const val VIEW_TYPE_PROFILE = 3
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_MOVIE -> PageViewHolder.MovieViewHolder(TabMovieViewBinding.inflate(inflater, parent, false))
            VIEW_TYPE_APP -> PageViewHolder.AppViewHolder(TabAppViewBinding.inflate(inflater, parent, false))
            VIEW_TYPE_SEARCH -> PageViewHolder.SearchViewHolder(TabSearchViewBinding.inflate(inflater, parent, false))
            VIEW_TYPE_PROFILE -> PageViewHolder.ProfileViewHolder(TabProfileViewBinding.inflate(inflater, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        Log.d("ViewPagerAdapter", "Item clicked at position: $position")
        val tab = tabs[position]
        when (holder) {
            is PageViewHolder.MovieViewHolder -> holder.bind()
            is PageViewHolder.AppViewHolder -> holder.bind()
            is PageViewHolder.SearchViewHolder -> holder.bind()
            is PageViewHolder.ProfileViewHolder -> holder.bind(workspaceUrl)

        }
    }

    override fun getItemViewType(position: Int) = when (position) {
        0 -> VIEW_TYPE_MOVIE
        1 -> VIEW_TYPE_APP
        2 -> VIEW_TYPE_SEARCH
        3 -> VIEW_TYPE_PROFILE
        else -> throw IllegalArgumentException("Invalid position")
    }

    override fun getItemCount() = tabs.size

sealed class PageViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class MovieViewHolder(private val binding: TabMovieViewBinding) : PageViewHolder(binding) {
        fun bind() {
//            binding.textMovie.text = "영화 탭"
        }
    }

    class SearchViewHolder(private val binding: TabSearchViewBinding) : PageViewHolder(binding) {
        fun bind() {
//            binding.textSearch.text = ""
        }
    }

    class AppViewHolder(private val binding: TabAppViewBinding): PageViewHolder(binding) {
        fun bind() {

        }
    }

    class ProfileViewHolder(private val binding: TabProfileViewBinding): PageViewHolder(binding) {
        fun bind(workspaceUrl: String) {
            addToolbarOption()
            addWorkspaceUrl(workspaceUrl)
            addGithubLink()

        }
        private fun addToolbarOption() {
            val toolbar = binding.toolbarUserInformation
            // ViewHolder에서는 setSupportActionBar를 사용할 수 없으므로, 간단히 타이틀만 설정합니다.
            toolbar.title = "프로필"
            toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_new_24)
            // 네비게이션 아이콘 클릭 리스너는 필요하다면 여기에 추가할 수 있습니다.
        }

        private fun addWorkspaceUrl(workspaceUrl: String) {
            binding.slackWorkspaceValue.text = workspaceUrl
        }

        private fun addGithubLink() {
            val textView = binding.githubValue
            val text = "hjlim7831"
            val spannableString = SpannableString(text)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hjlim7831"))
                    widget.context.startActivity(intent)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                }
            }

            spannableString.setSpan(clickableSpan, 0, text.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

            textView.text = spannableString
            textView.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}
}