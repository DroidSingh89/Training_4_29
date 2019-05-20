package com.example.training_4_29.model.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.training_4_29.model.entities.Animal

@Dao
interface AnimalDao {

    @Insert
    fun saveAnimal(animal: Animal)

    @Query("SELECT * FROM Animal")
    fun getJungle(): List<Animal>

}