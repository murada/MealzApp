package com.meals.data.api

import com.meals.domain.entity.CategoryResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorMealsApi(val ktorClient: HttpClient) {

    suspend fun getMeals(): CategoryResponse {
        return ktorClient.get("https://www.themealdb.com/api/json/v1/1/categories.php")
    }

}