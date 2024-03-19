package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentGamePageBinding

class GamePageFragment : Fragment() {

    private lateinit var binding : FragmentGamePageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //delegation
        val bundle : GamePageFragmentArgs by navArgs()

        val incomingName = bundle.name
        val incomingAge = bundle.age
        val incomingMarital = bundle.marital
        val incomingHeight = bundle.height

        Log.e("Incoming name",incomingName)
        Log.e("Incoming age",incomingAge.toString())
        Log.e("Incoming marital",incomingMarital.toString())
        Log.e("Incoming height",incomingHeight.toString())

        binding = FragmentGamePageBinding.inflate(inflater,container,false)
        binding.buttonFinish.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goToResultPage)
        }
        return binding.root

    }

}