package com.meals.domain.entity

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val mealId: String,
    @SerializedName("strMeal")
    val mealName: String,
    @SerializedName("strMealThumb")
    val mealThumb: String
)
