package com.meals.domain.entity

import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)
