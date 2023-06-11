package com.meals.mealzapp.ui.meals.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meals.domain.entity.Category
import com.meals.domain.usecases.GetMealByIdUseCase
import com.meals.domain.usecases.GetMealsCategoriesUseCase
import com.meals.mealzapp.model.repositories.MealsRepository
import com.meals.mealzapp.model.response.CategoryResponse
import com.meals.mealzapp.ui.navigation.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val getMealByIdUseCase: GetMealByIdUseCase
) : ViewModel() {

    var mealState = mutableStateOf<Category?>(null)

    init {
        val mealId = savedStateHandle.get<String>(NavigationKeys.MEAL_DETAIL_ARGUMENT)
        viewModelScope.launch {
            mealState.value = mealId?.let { getMealByIdUseCase(it) }

        }
    }

}