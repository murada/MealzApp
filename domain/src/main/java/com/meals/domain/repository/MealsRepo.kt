package com.meals.domain.repository

import com.meals.domain.entity.Category
import com.meals.domain.entity.Meal

interface MealsRepo {
    suspend fun getCategories(): List<Category>
    fun getCategoryById(id: String): Category?

    suspend fun getMealsByCategory(categoryId: String): List<Meal>
}