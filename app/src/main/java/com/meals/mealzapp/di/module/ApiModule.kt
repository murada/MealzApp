package com.meals.mealzapp.di.module

import com.meals.data.api.MealsApi
import com.meals.data.repository.MealsRepoImpl
import com.meals.domain.repository.MealsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideMealApi(retrofit: Retrofit): MealsApi {
        return retrofit.create(MealsApi::class.java)
    }

}