package com.example.mealzapp.model.repositories

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.model.response.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(val mealsWebService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealCategoriesResponse?) -> Unit) {
        return mealsWebService.getMeals().enqueue(object : Callback<MealCategoriesResponse> {
            override fun onResponse(
                call: Call<MealCategoriesResponse>,
                response: Response<MealCategoriesResponse>
            ) {
                if (response.isSuccessful) {
                    successCallback(response.body())
                }
            }

            override fun onFailure(call: Call<MealCategoriesResponse>, t: Throwable) {
                //TODO: Handle error
            }
        })
    }
}