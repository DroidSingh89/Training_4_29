package com.example.applicationphil

import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun setContentView(layoutResID: Int) {
        val fullView = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        val activityContainer = fullView.findViewById<FrameLayout>(R.id.hosted_activity)
        layoutInflater.inflate(layoutResID, activityContainer, true)
        super.setContentView(fullView)
        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = "Activity Title"

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close )
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true;
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.container -> {
                startActivity(Intent())
            }
            R.id.layouts -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }
}