package com.gulcihan.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.gulcihan.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val countries = ArrayList<String>()             //dataset
    private lateinit var dataAdapter :ArrayAdapter<String> //Processing the dataset

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countries.add("Turkey")
        countries.add("USA")
        countries.add("Germany")
        countries.add("Japan")
        countries.add("Brazil")
        countries.add("Australia")

        //veri kumesini adapter ile spinner uzerine eklemis olacagız. tasarım uzerindeki text1'e verileri yerlestir.
        dataAdapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,android.R.id.text1,countries)
        binding.spinner.adapter = dataAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected Country : ${countries[position]}" , Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.buttonShow.setOnClickListener {
            Toast.makeText(applicationContext, "Country : ${countries[binding.spinner.selectedItemPosition]}" , Toast.LENGTH_LONG).show()

        }
    }
}