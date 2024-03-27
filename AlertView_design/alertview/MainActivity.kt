package com.gulcihan.alertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.gulcihan.alertview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setMessage("Message")
            dialog.setTitle("Alert")
            dialog.setIcon(R.drawable.image)

            dialog.setPositiveButton("Ok"){ _, _ ->
                Toast.makeText(applicationContext , "Okay",Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton("Close") { _, _ ->
                Toast.makeText(applicationContext , "Closed",Toast.LENGTH_SHORT).show()

            }
            dialog.create().show() //show AlertDialog
        }

        binding.button2.setOnClickListener {
            val design = layoutInflater.inflate(R.layout.activity_alert_view_design,null)
            val editTextAlert = design.findViewById(R.id.editTextAlert) as EditText

            val dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setMessage("Message")
            dialog.setTitle("Special button")
            dialog.setIcon(R.drawable.image)

            dialog.setView(design)

            dialog.setPositiveButton("Save"){ _,_ ->
                val incomingData = editTextAlert.text.toString()

                Toast.makeText(applicationContext , "Saved : $incomingData" , Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext , "Cancelled" , Toast.LENGTH_SHORT).show()
            }

            dialog.create().show()
        }


    }
}