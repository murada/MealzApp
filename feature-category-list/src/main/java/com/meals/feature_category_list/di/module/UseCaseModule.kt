package com.meals.feature_category_list.di.module

import com.meals.domain.repository.MealsRepo
import com.meals.domain.usecases.GetCategoryByIdUseCase
import com.meals.domain.usecases.GetMealsByCategoryUseCase
import com.meals.domain.usecases.GetMealsCategoriesUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { provideGetMealsByCategoryUseCase(get()) }
    single { provideGetMealsByCategoryUseCase1(get()) }
    single { provideGetMealByIdUseCase(get()) }
}

fun provideGetMealByIdUseCase(mealsRepo: MealsRepo): GetCategoryByIdUseCase {
    return GetCategoryByIdUseCase(mealsRepo)
}

fun provideGetMealsByCategoryUseCase(mealsRepo: MealsRepo): GetMealsCategoriesUseCase {
    return GetMealsCategoriesUseCase(mealsRepo)
}

fun provideGetMealsByCategoryUseCase1(mealsRepo: MealsRepo): GetMealsByCategoryUseCase {
    return GetMealsByCategoryUseCase(mealsRepo)
}
