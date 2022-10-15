package com.example.testtask

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.testtask.data.AppDatabase

class App : Application() {

    private var database: AppDatabase? = null
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        var instance: App? = null
    }

}