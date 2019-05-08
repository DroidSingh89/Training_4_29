package com.example.applicationphil.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.applicationphil.BaseActivity
import com.example.applicationphil.R
import com.example.applicationphil.adapter.AnimalListAdapter
import com.example.applicationphil.adapter.PersonListAdapter
import com.example.applicationphil.model.entities.animalGenerator
import com.example.applicationphil.model.entities.personGenerator

class ContainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val lvSimple = findViewById<ListView>(R.id.lvSimple) as ListView
        val lvPerson = findViewById<ListView>(R.id.lvPerson) as ListView
        val rvAnimal = findViewById<RecyclerView>(R.id.rvAnimal)

        lvSimple.adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            personGenerator(10))

        lvPerson.adapter = PersonListAdapter(
            applicationContext,
            R.layout.list_item_person,
            personGenerator(12)
        )

        rvAnimal.layoutManager = LinearLayoutManager(this)
        rvAnimal.adapter = AnimalListAdapter(animalGenerator(20))
    }
}
