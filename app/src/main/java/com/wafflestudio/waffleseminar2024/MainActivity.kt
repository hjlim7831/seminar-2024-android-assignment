package com.wafflestudio.waffleseminar2024

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wafflestudio.waffleseminar2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addToolbarOption()
        addWorkspaceUrlEditTextOption()
        addContinueButtonOption()
    }

    private fun addToolbarOption() {
        val toolbar: Toolbar = binding.toolbarMain
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "로그인"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_new_24)
    }

    private fun addWorkspaceUrlEditTextOption() {
        val editText: EditText = binding.workspaceUrl
        val button: Button = binding.buttonContinue
        editText.hint = "workspace-url.slack.com"
        editText.addTextChangedListener(WorkspaceUrlTextWatcher(editText, button))
    }

    private fun addContinueButtonOption() {
        val editText: EditText = binding.workspaceUrl
        val button: Button = binding.buttonContinue

        button.setOnClickListener {
            val workspaceUrl = editText.text.toString()
            val intent = Intent(this, HomeTabActivity::class.java)
            intent.putExtra("WORKSPACE_URL", workspaceUrl)
            startActivity(intent)
        }
    }
}