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
            val person = People(1,"Mehmet")
            val transition = HomePageFragmentDirections.goToGamePage(person,"Ahmet",18,1.78f,true)

            //Navigation.findNavController(it).navigate(R.id.goToGamePage)
            Navigation.findNavController(it).navigate(transition) //hem geçiş oluyor hem de veriler aktarılıyor
        }
        return binding.root
    }

}