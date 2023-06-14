package com.meals.feature_category_list.di.module

import com.meals.data.repository.MealsRepoImpl
import com.meals.domain.repository.MealsRepo
import org.koin.dsl.module


val repoModule = module {
    single <MealsRepo>{ MealsRepoImpl(get()) }
}

fun provideMealsRepo(mealsRepoImpl: MealsRepoImpl): MealsRepo{
    return mealsRepoImpl
}