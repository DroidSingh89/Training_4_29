package com.example.applicationphil.model.data.room

import android.arch.persistence.room.Room
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.applicationphil.model.entities.Animal

class AnimalRepository(val applicationContext: Context) {

    val db = Room.databaseBuilder(
        applicationContext,
        AnimalDatabase::class.java,
        "database-name"
    ).build()

    fun saveAnimal(animal: Animal){
        Thread {
            db.animalDao().saveAnimal(animal)
            Log.d(TAG, "save Animal: ${animal.toString()}")
        }.start()

    }

    fun getJungle(callback: (List<Animal>) -> Unit){

        Thread {
            val list = db.animalDao().getJungle()
            Log.d(TAG, "get Jungle: $list")
            callback.invoke(list)
        }.start()

    }

}