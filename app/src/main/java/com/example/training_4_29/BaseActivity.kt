package com.example.training_4_29

import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.training_4_29.ui.activity.*
import com.example.training_4_29.ui.activity.firebase.FirebaseActivity
import com.example.training_4_29.ui.activity.github.GithubActivity
import com.google.android.material.navigation.NavigationView


open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    protected fun useToolbar():Boolean = true

    override fun setContentView(layoutResID: Int) {
        setNavigationDrawer(layoutResID)
    }

    private fun setNavigationDrawer(layoutResID: Int) {
        val fullView = layoutInflater.inflate(R.layout.activity_base, null) as androidx.drawerlayout.widget.DrawerLayout
        val activityContainer = fullView.findViewById<View>(R.id.activity_content) as FrameLayout
        layoutInflater.inflate(layoutResID, activityContainer, true)
        super.setContentView(fullView)

        val toolbar = findViewById<View>(R.id.myToolbar) as Toolbar
        //setup toolbar
        if (useToolbar()){
            setSupportActionBar(toolbar)
            title = "Training 4.29"
//            setup for using the navigation toggle menu on toolbar
            val drawerLayout = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawer_layout)
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
            R.id.firebase-> {
                startActivity(Intent(applicationContext, FirebaseActivity::class.java))
            }

            R.id.github-> {
                startActivity(Intent(applicationContext, GithubActivity::class.java))
            }

            R.id.maps-> {
                startActivity(Intent(applicationContext, MapsActivity::class.java))
            }
            R.id.customview-> {
                startActivity(Intent(applicationContext, CustomViewActivity::class.java))
            }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}