package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.repositories.MealsRepository

class MealsViewModel(private val mealsRepository: MealsRepository=MealsRepository()):ViewModel() {

    fun getMeals() = mealsRepository.getMeals().categoriesList
}