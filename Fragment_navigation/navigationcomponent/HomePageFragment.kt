package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponent.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private lateinit var binding : FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        binding.buttonStart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goToGamePage)

        }


        return binding.root
    }

}