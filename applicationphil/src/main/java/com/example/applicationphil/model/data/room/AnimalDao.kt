package com.example.applicationphil.model.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.applicationphil.model.entities.Animal

@Dao
interface AnimalDao {

    @Insert
    fun saveAnimal(animal: Animal)

    @Query("SELECT * FROM animal")
    fun getJungle(): List<Animal>

}