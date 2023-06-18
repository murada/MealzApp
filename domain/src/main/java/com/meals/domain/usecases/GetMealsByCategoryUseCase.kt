package com.meals.domain.usecases

import com.meals.domain.repository.MealsRepo

class GetMealsByCategoryUseCase (private val mealsRepo: MealsRepo){

    suspend operator fun invoke( categoryId:String) = mealsRepo.getMealsByCategory(categoryId)
}