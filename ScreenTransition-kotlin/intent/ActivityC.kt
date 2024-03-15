package com.example.intent


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityCBinding

private lateinit var binding : ActivityCBinding

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    //C activity'den geri tusuna basınca direkt MainActivity'e gitmek için onBackPressed kullanılır
    override fun onBackPressed() {
        val intent = Intent(this@ActivityC,MainActivity::class.java)
        startActivity(intent)

    }

}
