package com.example.mealzapp.model.repositories

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.model.response.MealCategoriesResponse


class MealsRepository(val mealsWebService: MealsWebService = MealsWebService()) {

    val mealCatergories: MutableList<CategoryResponse> = mutableListOf()

    suspend fun getMeals():MealCategoriesResponse {
        val response = mealsWebService.getMeals()
        mealCatergories.addAll(response.categoriesList)
        return response
    }

    fun getMealById(id: String):CategoryResponse? {
        return mealCatergories.firstOrNull { it.categoryId == id }
    }

    companion object  {
      @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }

}