package com.meals.data.api

import com.meals.domain.entity.CategoryResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}