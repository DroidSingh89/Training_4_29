package com.example.applicationphil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.applicationphil.model.entities.personGenerator

class ContainerActivity : BaseActivity() {

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
