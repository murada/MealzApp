package com.meals.mealzapp.di.module

import com.meals.data.api.MealsApi
import org.koin.dsl.module
import retrofit2.Retrofit


val apiModule = module {
    single { provideMealApi(get()) }
}

fun provideMealApi(retrofit: Retrofit): MealsApi {
    return retrofit.create(MealsApi::class.java)
}

