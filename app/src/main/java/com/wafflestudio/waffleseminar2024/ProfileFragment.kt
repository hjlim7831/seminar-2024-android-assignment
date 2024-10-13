package com.wafflestudio.waffleseminar2024

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.wafflestudio.waffleseminar2024.databinding.TabProfileViewBinding

class ProfileFragment: Fragment() {

    private var _binding: TabProfileViewBinding? = null
    private val binding get() = _binding!!

    companion object {
        // Fragment에 데이터를 전달하기 위한 메서드
        fun newInstance(workspaceUrl: String): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            args.putString("WORKSPACE_URL", workspaceUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workspaceUrl = arguments?.getString("WORKSPACE_URL")
        addToolbarOption()
        addWorkspaceUrl(workspaceUrl)
        addGithubLink()
        addOptionMenu()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = TabProfileViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 메모리 누수 방지
        _binding = null
    }


    private fun addToolbarOption() {
        val toolbar: Toolbar = binding.toolbarUserInformation
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "프로필"
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_new_24)
        }
    }

    private fun addWorkspaceUrl(workspaceUrl: String?) {
        val slackWorkspaceValueView: TextView = binding.slackWorkspaceValue
        slackWorkspaceValueView.text = workspaceUrl
    }

    private fun addGithubLink() {
        val textView: TextView = binding.githubValue
        val text = "hjlim7831"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: android.view.View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hjlim7831"))
                startActivity(intent)
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

    private fun addOptionMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // 메뉴를 inflate하여 추가
                menuInflater.inflate(R.menu.menu_user_information, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        })
    }

}