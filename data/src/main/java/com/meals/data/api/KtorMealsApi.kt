package com.meals.data.api

import com.meals.domain.entity.CategoryResponse
import com.meals.domain.entity.MealsResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorMealsApi(val ktorClient: HttpClient) {

    suspend fun getMealsCategories(): CategoryResponse {
        return ktorClient.get(path = "categories.php")
    }

    suspend fun getMealsByCategory(categoryId: String): MealsResponse {
        return ktorClient.get(path = "filter.php?c=$categoryId")
    }
}