package com.gulcihan.progress_slider_rating_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import com.google.android.material.slider.Slider
import com.gulcihan.progress_slider_rating_bar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }

        binding.buttonStop.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
        }

        binding.Slider.setOnSeekBarChangeListener(object  : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //binding.textViewResult.text = progress.toString()
                binding.textViewResult.text = "Slider result = $progress"

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.buttonShow.setOnClickListener {
            val sliderProgress = binding.Slider.progress
            val ratingBar = binding.ratingBar.rating

            Log.e("slider Progress " ,sliderProgress.toString())
            Log.e("ratingBar",ratingBar.toString())
        }
    }
}