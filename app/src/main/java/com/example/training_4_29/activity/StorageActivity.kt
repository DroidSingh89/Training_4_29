package com.example.training_4_29.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.adapter.PersonListAdapter
import com.example.training_4_29.model.data.room.AnimalRepository
import com.example.training_4_29.model.data.sqlite.PersonContract
import com.example.training_4_29.model.data.sqlite.PersonDatabase
import com.example.training_4_29.model.entities.Animal
import com.example.training_4_29.model.entities.Person
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_storage.*
import kotlinx.android.synthetic.main.person_layout.*

class StorageActivity : BaseActivity(), View.OnClickListener {

    lateinit var animalRepository: AnimalRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)


        animalRepository = AnimalRepository(applicationContext)

//        setting up shared preferences
        val sharedPref: SharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()

        btnSaveData.setOnClickListener {
            editor.putString("value", etSharedPref.text.toString())
//            editor.commit() //commit() return boolean and would write the data
//            synchronously, apply() would do async
            editor.apply()
            toast("Saved")
        }
        btnGetData.setOnClickListener { toast(sharedPref.getString("value", "default value")) }
        btnClearData.setOnClickListener {
            editor.clear()
            editor.apply()
            toast("Cleared")
        }

//        setting up PersonDatabase using SQLite
        val personDatabase: PersonDatabase =
            PersonDatabase(
                this
                ,
                PersonContract.DATABASE_NAME,
                PersonContract.VERSION_NUMBER
            )

        val adapter = PersonListAdapter(applicationContext, R.layout.list_item_person, mutableListOf())
        lvPersonList.adapter = adapter

        btnSavePerson.setOnClickListener {
            val rowId = personDatabase.savePerson(
                Person(
                    etPersonName.text.toString(),
                    etPersonAge.text.toString().toInt(),
                    etPersonGender.text.toString()
                )
            )
            toast("Saved on row: $rowId")

            //clear the edittext
            etPersonAge.text.clear()
        }

        btnGetAllPerson.setOnClickListener {

            adapter.updatePersonList(personDatabase.getAllPerson())

        }


//      setting up listeners for room database
        btnSaveAnimal.setOnClickListener(this)
        btnGetJungle.setOnClickListener(this)


    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btnSaveAnimal -> animalRepository.saveAnimal(Animal())
            R.id.btnGetJungle -> animalRepository.getJungle { list -> runOnUiThread { printList(list) } }

        }
    }

    private fun printList(list: List<Animal>) {
        list.forEach { toast(it.toString()) }
    }
}
