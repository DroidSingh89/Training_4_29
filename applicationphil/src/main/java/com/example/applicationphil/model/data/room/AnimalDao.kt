package com.example.applicationphil.model.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.applicationphil.model.entities.Animal

@Dao
interface AnimalDao {

    @Insert
    fun saveAnimal(animal: Animal)

    @Query("SELECT * FROM animal")
    fun getJungle(): List<Animal>

}