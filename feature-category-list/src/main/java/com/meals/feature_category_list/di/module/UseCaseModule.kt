package com.meals.feature_category_list.di.module

import com.meals.domain.repository.MealsRepo
import com.meals.domain.usecases.GetMealByIdUseCase
import com.meals.domain.usecases.GetMealsCategoriesUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { provideGetMealsByCategoryUseCase(get()) }
    single { provideGetMealByIdUseCase(get()) }
}

fun provideGetMealByIdUseCase(mealsRepo: MealsRepo): GetMealByIdUseCase {
    return GetMealByIdUseCase(mealsRepo)
}

fun provideGetMealsByCategoryUseCase(mealsRepo: MealsRepo): GetMealsCategoriesUseCase {
    return GetMealsCategoriesUseCase(mealsRepo)
}