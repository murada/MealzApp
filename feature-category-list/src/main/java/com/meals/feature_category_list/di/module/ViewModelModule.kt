package com.meals.feature_category_list.di.module

import com.meals.feature_category_list.meals.detail.MealDetailViewModel
import com.meals.feature_category_list.meals.list.MealsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MealDetailViewModel(get(),get(),get()) }
    viewModel { MealsViewModel(get()) }
}