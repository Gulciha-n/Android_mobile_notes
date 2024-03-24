package com.gulcihan.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.gulcihan.snackbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //use material design library for Snackbar

        binding.buttonNormal.setOnClickListener {view ->   //view -> indicates buttonNormal
            Snackbar.make(view,"Hello",Snackbar.LENGTH_SHORT).show()
            //snackbar, hangi gorsel nesne onu calıstıracaksa onun nesnesini alır
        }


        binding.buttonReturn.setOnClickListener {viewObje ->
            //geri donus degerı olan snackbar, tıklanıldıgında yeni snackbar acar
            Snackbar.make(viewObje,"Should the message be deleted?",Snackbar.LENGTH_LONG)
                .setAction("Yes"){setObje ->
                    Snackbar.make(setObje,"Message deleted!",Snackbar.LENGTH_LONG).show()
                }
                .show()
        }


        binding.buttonSpecial.setOnClickListener {view ->

            val snackbar = Snackbar.make(view,"No Internet connection",Snackbar.LENGTH_LONG)
            snackbar.setAction("Try Again"){
            }
            snackbar.setActionTextColor(Color.RED)
            snackbar.setTextColor(Color.BLUE)
            snackbar.setBackgroundTint(Color.WHITE)
            snackbar.show()
        }
    }
}