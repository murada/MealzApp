package com.meals.mealzapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideGson() }
    single(qualifier = StringQualifier("BASE_URL")) { provideBaseUrl()}
    single { provideGsonConverterFactory() }
    single { provieRetrofitClient(get(qualifier = StringQualifier("BASE_URL")),get()) }

}

private fun provieRetrofitClient(baseUrl: String,gsonConverterFactory:GsonConverterFactory): Retrofit =
    Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory).build()

private fun provideGson(): Gson? = GsonBuilder().create()

fun provideBaseUrl(): String {
    return "https://www.themealdb.com/api/json/v1/1/"
}

fun provideGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}