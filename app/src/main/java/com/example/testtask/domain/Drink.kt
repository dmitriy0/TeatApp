package com.example.testtask.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Drink(
    @SerializedName("idDrink")
    @PrimaryKey
    val id: String,
    @SerializedName("strDrink")
    val title: String,
    @SerializedName("strInstructions")
    val description: String,
    @SerializedName("strDrinkThumb")
    val image: String,
)

data class Json(
    @SerializedName("drinks")
    val drinkList: List<Drink>
)