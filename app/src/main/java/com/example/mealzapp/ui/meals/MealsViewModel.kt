package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.repositories.MealsRepository
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.model.response.MealCategoriesResponse

class MealsViewModel(private val mealsRepository: MealsRepository=MealsRepository()):ViewModel() {

    suspend fun getMeals():List<CategoryResponse> {
        return  mealsRepository.getMeals().categoriesList
    }
}