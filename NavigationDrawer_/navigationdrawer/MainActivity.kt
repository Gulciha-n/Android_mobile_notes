package com.gulcihan.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.gulcihan.navigationdrawer.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding nav_host_fragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //combine navigationView & navHostFragment
        NavigationUI.setupWithNavController(binding.navigationView , navHostFragment.navController)

        binding.toolbar.title = "Title"

        val toogle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toogle)
        toogle.syncState()

        val title = binding.navigationView.inflateHeaderView(R.layout.navigation_title)
        val textViewTitle = title.findViewById(R.id.textViewTitle) as TextView
        textViewTitle.text = "Hello"

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)

        }else{
            onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }
}