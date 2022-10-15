package com.example.testtask.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testtask.App
import com.example.testtask.domain.Drink
import com.example.testtask.domain.Json
import com.example.testtask.domain.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RepositoryImpl : Repository {

    private val coffeeLiveData = MutableLiveData<List<Drink>>()
    private val dao = App.instance?.getDatabase()?.personDao

    override fun getDrinkList(): LiveData<List<Drink>> {

        GlobalScope.launch {
            val drinkList = dao?.getDrinkList()
            if (drinkList?.isEmpty() == true) {
                requestToApi()
            } else {
                coffeeLiveData.postValue(drinkList)
            }

        }
        return coffeeLiveData
    }

    private fun requestToApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        apiService.getDrinkList().enqueue(object : Callback<Json> {
            override fun onResponse(call: Call<Json>, response: Response<Json>) {
                Log.d("mytag", response.body().toString())

                GlobalScope.launch {
                    dao?.addDrinkList(response.body()!!.drinkList)
                    coffeeLiveData.postValue(response.body()!!.drinkList)
                }
            }

            override fun onFailure(call: Call<Json>, t: Throwable) {

            }

        })
    }

}