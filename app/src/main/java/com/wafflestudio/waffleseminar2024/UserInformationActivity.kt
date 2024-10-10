package com.wafflestudio.waffleseminar2024

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.wafflestudio.waffleseminar2024.databinding.TabProfileViewBinding

class UserInformationActivity: AppCompatActivity() {
    private lateinit var binding: TabProfileViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("UserInformationActivity", "onCreate called")
        binding = TabProfileViewBinding.inflate(layoutInflater)
        Log.d("check run", "setContentView : UserInformationActivity")
        setContentView(binding.root)

        Log.d("UserInformationActivity", "Intent extras: ${intent.extras}")
        val workspaceUrl = intent.getStringExtra("WORKSPACE_URL")
        Log.d("UserInformationActivity", "Received WORKSPACE_URL: $workspaceUrl")

        addToolbarOption()
        addWorkspaceUrl()
        addGithubLink()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_user_information, menu)
        return true
    }
    
    private fun addToolbarOption() {
        val toolbar: Toolbar = binding.toolbarUserInformation
        setSupportActionBar(toolbar)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "프로필"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_new_24)
    }

    private fun addWorkspaceUrl() {
        val slackWorkspaceValueView: TextView = binding.slackWorkspaceValue
        val workspaceUrl = intent.getStringExtra("WORKSPACE_URL")
        slackWorkspaceValueView.text = workspaceUrl
        Log.d("UserInformationActivity", "Setting WORKSPACE_URL to TextView: $workspaceUrl")
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
}