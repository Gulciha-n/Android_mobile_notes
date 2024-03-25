package com.gulcihan.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gulcihan.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true

        binding.webView.loadUrl("https://www.vodafone.com.tr/")

    }
}