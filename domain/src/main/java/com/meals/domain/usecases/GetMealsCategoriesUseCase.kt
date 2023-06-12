package com.meals.domain.usecases

import com.meals.domain.repository.MealsRepo
import javax.inject.Inject

class GetMealsCategoriesUseCase (private val mealsRepo: MealsRepo){

    suspend operator fun invoke() = mealsRepo.getCategories()
}