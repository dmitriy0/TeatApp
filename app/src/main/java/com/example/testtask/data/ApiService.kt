package com.example.testtask.data

import com.example.testtask.domain.Json
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("search.php?s=margarita")
    fun getDrinkList(): Call<Json>

}