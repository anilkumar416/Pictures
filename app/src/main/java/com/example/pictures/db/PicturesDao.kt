package com.example.pictures.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PicturesDao {

    @Query("SELECT * FROM plants")
    fun getPlants(): LiveData<List<Pictures>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlant(plantId: Int): LiveData<Pictures>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Pictures>)
}