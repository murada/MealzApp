package com.meals.mealzapp

import android.app.Application
import com.meals.mealzapp.di.module.apiModule
import com.meals.mealzapp.di.module.networkModule
import com.meals.mealzapp.di.module.repoModule
import com.meals.mealzapp.di.module.useCaseModule
import com.meals.mealzapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealsApp() : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MealsApp)
            modules(listOf(networkModule, apiModule, repoModule, useCaseModule,viewModelModule))
        }
    }
}