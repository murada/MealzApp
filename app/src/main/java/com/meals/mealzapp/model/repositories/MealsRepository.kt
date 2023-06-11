package com.meals.mealzapp.model.repositories

import com.meals.mealzapp.model.api.MealsWebService
import com.meals.mealzapp.model.response.CategoryResponse
import com.meals.mealzapp.model.response.MealCategoriesResponse


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