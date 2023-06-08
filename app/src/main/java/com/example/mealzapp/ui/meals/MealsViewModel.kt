package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.repositories.MealsRepository
import com.example.mealzapp.model.response.MealCategoriesResponse

class MealsViewModel(private val mealsRepository: MealsRepository=MealsRepository()):ViewModel() {

    fun getMeals(successCallback: (response: MealCategoriesResponse?) -> Unit) {
        mealsRepository.getMeals(){
            successCallback(it)
        }
    }
}