package com.example.applicationphil.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.example.applicationphil.BaseActivity
import com.example.applicationphil.R
import com.example.applicationphil.adapter.PersonListAdapter
import com.example.applicationphil.model.data.sqlite.PersonContract
import com.example.applicationphil.model.data.sqlite.PersonDatabase
import com.example.applicationphil.model.entities.Person
import com.example.applicationphil.util.toast
import kotlinx.android.synthetic.main.activity_storage.*
import kotlinx.android.synthetic.main.person_input_layout.*

class StorageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        // Shared Preferences
        val sharedPrefData = etSharedPreferences
        val sharedPref: SharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()

        btnSaveData.setOnClickListener {
            editor.putString("value", sharedPrefData.text.toString())
//            editor.commit() //commit would write the data synchronously, apply() writes async
            editor.apply()
        }
        btnGetData.setOnClickListener { toast(sharedPref.getString("value", "default value")) }
        btnClearData.setOnClickListener {
            editor.clear()
            editor.apply()
        }

        //Setting up PersonDatabase
        val personDatabase = PersonDatabase(
            applicationContext,
            PersonContract.DATABASE_NAME,
            PersonContract.VERSION_NUMBER
        )

        val adapter = PersonListAdapter(applicationContext, R.layout.list_item_person, mutableListOf())
        lvPersonList.adapter = adapter

        btnSavePerson.setOnClickListener {
            val rowID = personDatabase.savePerson(
                Person(
                    etPersonName.text.toString(),
                    etPersonAge.text.toString().toInt(),
                    etPersonGender.text.toString()
                )
            )
            etPersonName.text.clear()
            etPersonAge.text.clear()
            etPersonGender.text.clear()
            toast("Saved on row: $rowID")
        }

        btnGetAllPeople.setOnClickListener {
            adapter.updatePersonList(personDatabase.getAllPerson())
        }
    }
}
