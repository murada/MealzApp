package com.example.mealzapp.model.repositories

import com.example.mealzapp.model.response.MealCategoriesResponse

class MealsRepository {
    fun getMeals():MealCategoriesResponse = MealCategoriesResponse(listOf())
}