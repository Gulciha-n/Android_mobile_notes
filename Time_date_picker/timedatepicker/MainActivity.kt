package com.gulcihan.timedatepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gulcihan.timedatepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextHour.setOnClickListener {
            val calendar = Calendar.getInstance()   //mevcut zaman bilgisini içeren bir Calendar nesnesi
            val hour = calendar.get(Calendar.HOUR_OF_DAY) //aktif saat bilgisi
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                binding.editTextHour.setText("$hourOfDay : $minute")
            },hour,minute,true)

            timePicker.setTitle("Set Hour")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Set",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",timePicker)
            timePicker.show()
        }


        binding.editTextDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.HOUR_OF_DAY)

            val datePicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.editTextDate.setText("$year/${month+1}/$day")
            },year,month,day)

            datePicker.setTitle("Set Date")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Set",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",datePicker)
            datePicker.show()
            }

        }
    }
