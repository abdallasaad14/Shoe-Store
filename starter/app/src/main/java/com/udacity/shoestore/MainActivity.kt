package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        @Suppress("UNUSED_VARIABLE")
        val binding=
            DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        // nav controller
        val navController = this.findNavController(R.id.myNavHostFragment)

        // appbar Navigation

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)

    }
        //go back navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }}

