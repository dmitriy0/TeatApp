package com.example.testtask.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.domain.Drink


@Database(
    entities = [Drink::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val personDao: DrinksDao?
}