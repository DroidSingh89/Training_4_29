package com.example.training_4_29

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.training_4_29.model.entities.personGenerator

class ContainerActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val lvSimple = findViewById<ListView>(R.id.lvSimple)
        val lvPersonList = findViewById<ListView>(R.id.lvPerson)
        val rvAnimalList = findViewById<RecyclerView>(R.id.rvAnimal)

        lvSimple.adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            personGenerator(10))


    }

}
