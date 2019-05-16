package com.example.training_4_29

import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import com.example.training_4_29.activity.*


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    protected fun useToolbar():Boolean = true

    override fun setContentView(layoutResID: Int) {

        setNavigationDrawer(layoutResID)

    }

    private fun setNavigationDrawer(layoutResID: Int) {
        val fullView = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        val activityContainer = fullView.findViewById<View>(R.id.activity_content) as FrameLayout
        layoutInflater.inflate(layoutResID, activityContainer, true)
        super.setContentView(fullView)

        val toolbar = findViewById<View>(R.id.myToolbar) as Toolbar
        //setup toolbar
        if (useToolbar()){
            setSupportActionBar(toolbar)
            title = "Training 4.29"
//            setup for using the navigation toggle menu on toolbar
            val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            val toggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.isDrawerIndicatorEnabled = true
            toggle.syncState()
        }



//        setup listener for navigation view
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        Log.d("MainTag", "onClickNavigationView")
        when (item.itemId) {
            R.id.container -> {
                startActivity(Intent(applicationContext, ContainerActivity::class.java))
            }
            R.id.dataStorage -> {
                startActivity(Intent(applicationContext, StorageActivity::class.java))
            }
            R.id.provider-> {
                startActivity(Intent(applicationContext, ProviderActivity::class.java))
            }

            R.id.threading-> {
                startActivity(Intent(applicationContext, ThreadingActivity::class.java))
            }
            R.id.receiver-> {
                startActivity(Intent(applicationContext, ReceiverActivity::class.java))
            }
            R.id.service-> {
                startActivity(Intent(applicationContext, ServiceActivity::class.java))
            }

            R.id.network-> {
                startActivity(Intent(applicationContext, NetworkActivity::class.java))
            }

            R.id.fragment-> {
                startActivity(Intent(applicationContext, FragmentActivity::class.java))
            }


        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}