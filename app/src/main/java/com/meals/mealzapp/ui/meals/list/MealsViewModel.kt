package com.meals.mealzapp.ui.meals.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meals.domain.entity.Category
import com.meals.domain.usecases.GetMealsCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val getMealsCategoriesUseCase: GetMealsCategoriesUseCase) :
    ViewModel() {

    init {
        viewModelScope.launch {
            val meals = getMeals()
            categoriesState.value = meals
        }
    }

    val categoriesState: MutableState<List<Category>> = mutableStateOf(emptyList())


    private suspend fun getMeals(): List<Category> {
        return getMealsCategoriesUseCase()
    }
}