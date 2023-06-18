package com.meals.domain.usecases

import com.meals.domain.repository.MealsRepo

class GetCategoryByIdUseCase (private val mealsRepo: MealsRepo){

    operator fun invoke(id: String) = mealsRepo.getCategoryById(id)
}