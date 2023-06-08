package com.example.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.repositories.MealsRepository
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.model.response.MealCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class MealsViewModel(private val mealsRepository: MealsRepository = MealsRepository()) :
    ViewModel() {

    init {
        viewModelScope.launch {
            val meals = getMeals()
            categoriesState.value = meals
        }
    }

    val categoriesState: MutableState<List<CategoryResponse>> = mutableStateOf(emptyList())


    private suspend fun getMeals(): List<CategoryResponse> {
        return mealsRepository.getMeals().categoriesList
    }
}