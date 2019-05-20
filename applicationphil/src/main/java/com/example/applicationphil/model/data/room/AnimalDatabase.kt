package com.example.applicationphil.model.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applicationphil.model.entities.Animal

@Database(entities = arrayOf(Animal::class), version = 1)
abstract class AnimalDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}