package com.meals.domain.repository

import com.meals.domain.entity.Category

interface MealsRepo {
    suspend fun getCategories(): List<Category>
    fun getMealById(id: String): Category?
}