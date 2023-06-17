package com.meals.data.repository

import com.meals.data.api.KtorMealsApi
import com.meals.domain.entity.Category
import com.meals.domain.repository.MealsRepo

class MealsRepoImpl (private val mealsApi: KtorMealsApi): MealsRepo {

    val categoriesList = mutableListOf<Category>()

    override suspend fun getCategories(): List<Category> {
        val categoriesList = mealsApi.getMeals().categoriesList
        this.categoriesList.addAll(categoriesList)
        return categoriesList
    }

    override fun getMealById(id: String): Category? {
        return categoriesList.firstOrNull { it.categoryId == id }
    }

}