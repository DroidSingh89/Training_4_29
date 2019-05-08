package com.example.training_4_29.model.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.training_4_29.model.entities.Animal

@Dao
interface AnimalDao {

    @Insert
    fun saveAnimal(animal: Animal)

    @Query("SELECT * FROM Animal")
    fun getJungle(): List<Animal>

}