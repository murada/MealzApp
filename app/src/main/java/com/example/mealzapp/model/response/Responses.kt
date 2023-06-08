package com.example.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class MealCategoriesResponse(@SerializedName("categories") val categoriesList: List<CategoryResponse>)

data class CategoryResponse(
    @SerializedName("idCategory")
    val categoryId: String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String,
    @SerializedName("strCategoryThumb")
    val categoryUrlImage: String
)