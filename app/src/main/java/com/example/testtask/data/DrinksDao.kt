package com.example.testtask.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testtask.domain.Drink

@Dao
interface DrinksDao {

    @Query("SELECT * FROM Drink")
    fun getDrinkList(): List<Drink>

    @Insert
    fun addDrinkList(drinkList: List<Drink>)
}