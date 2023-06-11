package com.meals.mealzapp.di.module

import com.meals.domain.repository.MealsRepo
import com.meals.domain.usecases.GetMealByIdUseCase
import com.meals.domain.usecases.GetMealsCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMealsByCategoryUseCase(mealsRepo: MealsRepo): GetMealsCategoriesUseCase {
        return GetMealsCategoriesUseCase(mealsRepo)
    }

    @Provides
    fun provideGetMealByIdUseCase(mealsRepo: MealsRepo): GetMealByIdUseCase {
        return GetMealByIdUseCase(mealsRepo)
    }
}