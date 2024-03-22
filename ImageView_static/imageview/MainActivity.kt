package com.gulcihan.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gulcihan.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonImage1.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.image1)
        }
        binding.buttonImage2.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.image2)
        }

    }
}