package com.meals.domain.usecases

import com.meals.domain.repository.MealsRepo

class GetMealsCategoriesUseCase (private val mealsRepo: MealsRepo){

    suspend operator fun invoke() = mealsRepo.getCategories()
}