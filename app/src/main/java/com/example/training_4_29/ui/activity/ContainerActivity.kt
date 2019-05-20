package com.example.training_4_29.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.adapter.AnimalListAdapter
import com.example.training_4_29.adapter.PersonListAdapter
import com.example.training_4_29.model.entities.animalGenerator
import com.example.training_4_29.model.entities.personGenerator


class ContainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)


        val lvSimple = findViewById<ListView?>(R.id.lvSimple)
        lvSimple?.adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listOf("one", "two", "three", "four"))

        val lvPerson = findViewById<ListView>(R.id.lvPerson)
        lvPerson.adapter = PersonListAdapter(this, R.layout.list_item_person,
                personGenerator(10))

        val rvAnimal = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvAnimal)
        rvAnimal.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rvAnimal.adapter = AnimalListAdapter(animalGenerator(20))
    }


}
