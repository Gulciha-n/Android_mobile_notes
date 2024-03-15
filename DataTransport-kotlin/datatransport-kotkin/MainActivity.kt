package com.example.datatransport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datatransport.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSend.setOnClickListener {
            val intent = Intent(this@MainActivity,ActivityB::class.java)

            val people = People(99999,"Ahmet", 23)

            intent.putExtra("Message","Hello")
            intent.putExtra("Age",23)
            intent.putExtra("Object",people)

            startActivity(intent)

        }

    }
}