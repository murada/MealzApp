package com.meals.data.repository

import com.meals.data.api.KtorMealsApi
import com.meals.domain.entity.Category
import com.meals.domain.entity.Meal
import com.meals.domain.repository.MealsRepo

class MealsRepoImpl (private val mealsApi: KtorMealsApi): MealsRepo {

    private val categoriesList = mutableListOf<Category>()

    override suspend fun getCategories(): List<Category> {
        val categoriesList = mealsApi.getMealsCategories().categoriesList
        this.categoriesList.addAll(categoriesList)
        return categoriesList
    }

    override fun getCategoryById(id: String): Category? {
        return categoriesList.firstOrNull { it.categoryId == id }
    }

    override suspend fun getMealsByCategory(categoryId: String): List<Meal> {
        return mealsApi.getMealsByCategory(categoryId).meals
    }

}