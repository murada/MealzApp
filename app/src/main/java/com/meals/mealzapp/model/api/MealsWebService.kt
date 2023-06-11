package com.meals.mealzapp.model.api

import com.meals.mealzapp.model.response.MealCategoriesResponse
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

    suspend fun getMeals() :MealCategoriesResponse{
        return mealApi.getMeals()
    }

    interface MealApi {
        @GET("categories.php")
        suspend fun getMeals(): MealCategoriesResponse
    }
}