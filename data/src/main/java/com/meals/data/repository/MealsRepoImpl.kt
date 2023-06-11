package com.meals.data.repository

import com.meals.data.api.MealsApi
import com.meals.domain.entity.Category
import com.meals.domain.repository.MealsRepo
import javax.inject.Inject

class MealsRepoImpl @Inject constructor(private val mealsApi: MealsApi): MealsRepo {

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