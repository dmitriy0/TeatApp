package com.example.testtask.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun getDrinkList(): LiveData<List<Drink>>

}