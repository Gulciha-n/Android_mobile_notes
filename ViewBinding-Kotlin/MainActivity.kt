package com.example.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Snackbar.make(it,"Hello",Snackbar.LENGTH_LONG).show()  //it = design.button
        }

    }
}