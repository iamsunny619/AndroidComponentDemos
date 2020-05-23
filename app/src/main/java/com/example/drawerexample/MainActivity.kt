package com.example.drawerexample

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.drawerexample.CustomDrawerClicks.CustomDraweClick
import com.example.drawerexample.Fragments.ChattFragemnt
import com.example.drawerexample.Fragments.Message
import com.example.drawerexample.Fragments.ProfileFragment
import com.example.drawerexample.NavCompDrawer.HostActivty
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        nav_view.setNavigationItemSelectedListener(this)
        val toggle =
            ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Message()).commit()
            nav_view.setCheckedItem(R.id.nav_message)
        }

    }

    override fun onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_message -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Message()).addToBackStack("message").commit()
            }
            R.id.nav_chat -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ChattFragemnt()).addToBackStack("chatt").commit()

            R.id.nav_profile -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment()).addToBackStack("profile")
                .commit()

            R.id.nav_share -> {
                Toast.makeText(this, "share menu clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_send -> Toast.makeText(this, "Send button clicked", Toast.LENGTH_SHORT).show()

            R.id.usingButton -> startActivity(Intent(this, CustomDraweClick::class.java))

            R.id.navComponentController -> startActivity(Intent(this, HostActivty::class.java))

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
