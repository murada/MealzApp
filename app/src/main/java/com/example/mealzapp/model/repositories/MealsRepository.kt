package com.example.mealzapp.model.repositories

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealCategoriesResponse


class MealsRepository(val mealsWebService: MealsWebService = MealsWebService()) {
    suspend fun getMeals():MealCategoriesResponse {
        return mealsWebService.getMeals()
    }
}