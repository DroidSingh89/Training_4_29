package com.example.applicationphil

import android.content.Intent
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import com.example.applicationphil.activity.*


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun setContentView(layoutResID: Int) {
        val fullView = layoutInflater.inflate(R.layout.activity_base, null) as androidx.drawerlayout.widget.DrawerLayout
        val hostedActivityContainer = fullView.findViewById(R.id.hosted_activity) as FrameLayout
        layoutInflater.inflate(layoutResID, hostedActivityContainer, true)
        val activityContainer = fullView.findViewById<FrameLayout>(R.id.hosted_activity)
        layoutInflater.inflate(layoutResID, activityContainer, true)
        super.setContentView(fullView)
        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = "Activity Title"

        val drawerLayout = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close )
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true;
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { item: MenuItem -> this.onNavigationItemSelected(item) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.container -> {
                startActivity(Intent(applicationContext, ContainerActivity::class.java))
            }
            R.id.layouts -> {
                startActivity(Intent(applicationContext, LayoutActivity::class.java))
            }
            R.id.intents -> {
                startActivity(Intent(applicationContext, IntentsActivity::class.java))
            }
            R.id.dataStorage -> {
                startActivity(Intent(applicationContext, StorageActivity::class.java))
            }
            R.id.contentProviders -> {
                startActivity(Intent(applicationContext, ProviderActivity::class.java))
            }
            R.id.threading -> {
                startActivity(Intent(applicationContext, ThreadingActivity::class.java))
            }
            else -> { }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }
}