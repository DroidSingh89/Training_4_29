package com.example.applicationphil.model.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.applicationphil.model.entities.Animal

@Database(entities = arrayOf(Animal::class), version = 1)
abstract class AnimalDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}