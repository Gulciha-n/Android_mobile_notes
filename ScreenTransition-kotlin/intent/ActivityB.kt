package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityBBinding

private lateinit var binding : ActivityBBinding

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonGoToC.setOnClickListener {

            val intent = Intent (this@ActivityB,ActivityC::class.java)
            startActivity(intent)

        }

    }
}