package com.example.datatransport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val incomingMessage = intent.getStringExtra("Message")
        val incomingAge = intent.getIntExtra("Age",0)

        val incomingPeople = intent.getSerializableExtra("Object") as People
        //serializableextra bizden bu türden bir şey ister. Ama biz kişiler nesnesinedn alacağız, bu yüzden casting işlemi (as) yapmalıyız.

        Log.e("Message", incomingMessage!!)
        Log.e("Age", incomingAge.toString())   //Log requests a string value
        Log.e("TC No",(incomingPeople.tcNo).toString())
        Log.e("Name",incomingPeople.name)
        Log.e("Age",(incomingPeople.age).toString())

    }
}