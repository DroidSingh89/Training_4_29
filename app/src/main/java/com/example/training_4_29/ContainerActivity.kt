package com.example.training_4_29

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.training_4_29.adapter.PersonListAdapter
import com.example.training_4_29.model.entities.personGenerator


class ContainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)


        val lvSimple = findViewById<ListView>(R.id.lvSimple)
        lvSimple.adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listOf("one", "two", "three", "four"))

        val lvPerson = findViewById<ListView>(R.id.lvPerson)
        lvPerson.adapter = PersonListAdapter(this, R.layout.list_item_person, personGenerator(10))

        val rvAnimal = findViewById<RecyclerView>(R.id.rvAnimal)
    }


}
