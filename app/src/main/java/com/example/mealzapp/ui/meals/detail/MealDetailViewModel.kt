package com.example.mealzapp.ui.meals.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.repositories.MealsRepository
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.ui.navigation.NavigationKeys

class MealDetailViewModel(val savedStateHandle: SavedStateHandle): ViewModel() {

    var mealState = mutableStateOf<CategoryResponse?>(null)

    init {
        val mealsRepository = MealsRepository.getInstance()

        val mealId = savedStateHandle.get<String>(NavigationKeys.MEAL_DETAIL_ARGUMENT)
        mealState.value = mealId?.let { mealsRepository.getMealById(it) }
    }

}