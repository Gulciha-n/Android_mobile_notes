package com.gulcihan.tab_layout

import FirstFragment
import SecondFragment
import ThirdFragment
import android.os.Bundle
import android.widget.TableLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.gulcihan.tab_layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fragmentList =ArrayList<Fragment>()
    private lateinit var binding :ActivityMainBinding
    private val fragmentTitleList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyViewPagerAdapter(this)
        binding.viewpager.adapter = adapter

        fragmentList.add(FirstFragment())
        fragmentList.add(SecondFragment())
        fragmentList.add(ThirdFragment())

        fragmentTitleList.add("First")
        fragmentTitleList.add("Second")
        fragmentTitleList.add("Third")

        TabLayoutMediator(binding.tablayout,binding.viewpager){tab,position ->
            tab.setText(fragmentTitleList[position])

        }.attach()

    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }

}