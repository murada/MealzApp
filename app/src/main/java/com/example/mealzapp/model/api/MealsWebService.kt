package com.example.mealzapp.model.api

import com.example.mealzapp.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {

    lateinit var mealApi: MealApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mealApi = retrofit.create(MealApi::class.java)
    }

    fun getMeals() :Call<MealCategoriesResponse>{
        return mealApi.getMeals()
    }

    interface MealApi {
        @GET("categories.php")
        fun getMeals(): Call<MealCategoriesResponse>
    }
}