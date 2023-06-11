package com.meals.domain.entity

import com.google.gson.annotations.SerializedName

data class CategoryResponse(@SerializedName("categories") val categoriesList: List<Category>)
