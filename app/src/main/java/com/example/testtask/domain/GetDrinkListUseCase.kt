package com.example.testtask.domain

import androidx.lifecycle.LiveData

class GetDrinkListUseCase(private val repository: Repository) {

    fun getDrinkList(): LiveData<List<Drink>> {
        return repository.getDrinkList()
    }

}