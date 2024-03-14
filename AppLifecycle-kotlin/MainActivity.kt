package com.example.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

            Log.e("onCreate","running")

        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","running")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume","running")

    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause","running")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","running")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart","running")
    }
}