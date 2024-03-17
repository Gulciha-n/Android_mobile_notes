package com.gulcihan.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gulcihan.todoapp.R
import com.gulcihan.todoapp.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {

    private  lateinit var binding: FragmentSaveBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSaveBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            save(name)

        }
        return binding.root

    }


    //kullanıcıdan aldıgımız ismi kaydedip logcatte gösterelim
    fun save(name : String){
        Log.e("ToDoAppOut save",name)

    }

}