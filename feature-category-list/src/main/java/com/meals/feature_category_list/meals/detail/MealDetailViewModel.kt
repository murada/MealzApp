package com.meals.feature_category_list.meals.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meals.domain.entity.Category
import com.meals.domain.entity.Meal
import com.meals.domain.usecases.GetCategoryByIdUseCase
import com.meals.domain.usecases.GetMealsByCategoryUseCase
import kotlinx.coroutines.launch


class MealDetailViewModel constructor(
    private val mealId: String?,
    private val getCategoryByIdUseCase: GetCategoryByIdUseCase,
    private val getMealsByCategoryUseCase: GetMealsByCategoryUseCase
) : ViewModel() {

    val mealList = mutableStateOf<List<Meal>>(emptyList())

    var mealState = mutableStateOf<Category?>(null)

    init {
//        val mealId = savedStateHandle.get<String>(NavigationKeys.MEAL_DETAIL_ARGUMENT)
        viewModelScope.launch {
            mealList.value = mealId?.let { getMealsByCategoryUseCase(it) } ?: emptyList()
//            mealState.value = mealId?.let { getCategoryByIdUseCase(it) }

        }
    }

}