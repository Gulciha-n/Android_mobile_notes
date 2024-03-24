package com.gulcihan.night_mode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.gulcihan.night_mode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNormal.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }

        binding.buttonNight.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        }
    }
}