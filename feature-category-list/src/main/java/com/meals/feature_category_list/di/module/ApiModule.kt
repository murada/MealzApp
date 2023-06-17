package com.meals.feature_category_list.di.module

import com.meals.data.api.KtorMealsApi
import io.ktor.client.HttpClient
import org.koin.dsl.module


val apiModule = module {
    single { provideKtorMealApi(get()) }
}

fun provideKtorMealApi(httpClient: HttpClient): KtorMealsApi {
    return KtorMealsApi(httpClient)
}