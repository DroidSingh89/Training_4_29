package com.example.training_4_29.model.data.room

import android.arch.persistence.room.Room
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.training_4_29.model.entities.Animal

class AnimalRepository(applicationContext: Context) {

    val db = Room.databaseBuilder(
        applicationContext,
        AnimalDatabase::class.java, "animal.db"
    ).build()

    fun saveAnimal(animal: Animal) {
        Thread {
            Log.d(TAG, "saveAnimal: ${animal.toString()}")
            db.animalDao().saveAnimal(animal)
        }.start()

    }

    fun getJungle(callback: (List<Animal>)-> Unit){
        Thread{
            val list = db.animalDao().getJungle()
            Log.d(TAG, "getJungle: $list")
            callback.invoke(list)
        }.start()
    }

}