package com.meals.mealzapp.di.module

import com.meals.data.repository.MealsRepoImpl
import com.meals.domain.repository.MealsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun provideMealsRepo(mealsRepoImpl: MealsRepoImpl): MealsRepo
}