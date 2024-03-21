package com.gulcihan.radiobuttoncheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gulcihan.radiobuttoncheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val javaState = binding.checkBoxJava.isChecked
            val kotlinState = binding.checkBoxKotlin.isChecked
            val androidStudioState = binding.radioButtonAndroidStudio
            val intellijState = binding.radioButtonIntelliJ.isChecked

            Log.e("java status",javaState.toString())
            Log.e("Kotlin status",kotlinState.toString())
            Log.e("Android Studio Status",androidStudioState.toString())
            Log.e("intellij status",intellijState.toString())
        }
        binding.radioButtonAndroidStudio.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this@MainActivity,"Congrats!",Toast.LENGTH_LONG).show()

            }
        }
    }
}