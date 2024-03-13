package com.example.logs

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Logs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call it as ContentValues in logcat
        // Error log
        Log.e(TAG, "This is an error message");

        // Warning log
        Log.w(TAG, "This is a warning message");

        // Information log
        Log.i(TAG, "This is an information message");

        // Debug log
        Log.d(TAG, "This is a debug message");

        // Verbose log
        Log.v(TAG, "This is a verbose message");

        println("************************************")

        //call it as "output" in logcat
        // Error log
        Log.e("Output", "This is an error message");

        // Warning log
        Log.w("Output", "This is a warning message");

        // Information log
        Log.i("Output", "This is an information message");

        // Debug log
        Log.d("Output", "This is a debug message");

        // Verbose log
        Log.v("Output", "This is a verbose message");

        /*

        Log.e(String, String) (error)
        Log.w(String, String) (warning)
        Log.i(String, String) (information)
        Log.d(String, String) (debug)
        Log.v(String, String) (verbose)

        ** call it as ContentValues in logcat

        */


    }
}