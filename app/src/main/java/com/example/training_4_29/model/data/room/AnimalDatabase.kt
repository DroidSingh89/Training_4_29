package com.example.training_4_29.model.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.training_4_29.model.entities.Animal

@Database(entities = arrayOf(Animal::class), version = 1)
abstract class AnimalDatabase: RoomDatabase(){
    abstract fun animalDao(): AnimalDao
}