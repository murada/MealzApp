package com.meals.feature_category_list.meals.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meals.domain.entity.Category
import com.meals.domain.usecases.GetMealByIdUseCase
import kotlinx.coroutines.launch


class MealDetailViewModel constructor(
    private val mealId: String?,
    private val getMealByIdUseCase: GetMealByIdUseCase
) : ViewModel() {

    var mealState = mutableStateOf<Category?>(null)

    init {
//        val mealId = savedStateHandle.get<String>(NavigationKeys.MEAL_DETAIL_ARGUMENT)
        viewModelScope.launch {
            mealState.value = mealId?.let { getMealByIdUseCase(it) }

        }
    }

}