package com.example.drawerexample.NavCompDrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.drawerexample.R
import kotlinx.android.synthetic.main.activity_host_activty.*


class HostActivty : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_activty)
        setSupportActionBar(toolBar)
        navController = Navigation.findNavController(this, R.id.fragment)
        naviagtionView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, drawer)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController, drawer
        )
    }
}
