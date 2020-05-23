package com.example.drawerexample.CustomDrawerClicks

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.drawerexample.CustomDrawerClicks.Activity.Actvity1
import com.example.drawerexample.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_custom_drawe_click.*

class CustomDraweClick : AppCompatActivity(), View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_drawe_click)
        NavDrawerView.setNavigationItemSelectedListener(this)
        imgHamburger.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgHamburger -> {
                hamburger()
            }
        }
    }

    private fun hamburger() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
        } else {
            drawer.openDrawer(GravityCompat.END)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        closeDrawer()
        when (item.itemId) {
            R.id.activity1 -> startActivity(Intent(this, Actvity1::class.java))
            R.id.toastPopup -> Toast.makeText(this, "clicked on toast", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
        }
    }
}
