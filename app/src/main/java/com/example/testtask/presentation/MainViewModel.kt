package com.example.testtask.presentation

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.data.RepositoryImpl
import com.example.testtask.domain.Drink
import com.example.testtask.domain.GetDrinkListUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getDrinkListUseCase = GetDrinkListUseCase(RepositoryImpl)
    val drinkLiveData = getDrinkListUseCase.getDrinkList()
    val buttonClickedLiveData = MutableLiveData<Button>()

    fun buttonClicked(button: Button) {
        buttonClickedLiveData.value = button
    }

}