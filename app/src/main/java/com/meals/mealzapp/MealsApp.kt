package com.meals.mealzapp

import android.app.Application
import com.meals.feature_category_list.di.module.apiModule
import com.meals.feature_category_list.di.module.networkModule
import com.meals.feature_category_list.di.module.repoModule
import com.meals.feature_category_list.di.module.useCaseModule
import com.meals.feature_category_list.di.module.viewModelModule
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