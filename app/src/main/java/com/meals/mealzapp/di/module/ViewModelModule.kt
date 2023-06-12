package com.meals.mealzapp.di.module

import androidx.lifecycle.SavedStateHandle
import com.meals.mealzapp.ui.meals.detail.MealDetailViewModel
import com.meals.mealzapp.ui.meals.list.MealsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MealDetailViewModel(get(),get()) }
    viewModel { MealsViewModel(get()) }
}