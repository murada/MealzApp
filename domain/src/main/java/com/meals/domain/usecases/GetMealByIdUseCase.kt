package com.meals.domain.usecases

import com.meals.domain.repository.MealsRepo
import javax.inject.Inject

class GetMealByIdUseCase (private val mealsRepo: MealsRepo){

    suspend operator fun invoke(id: String) = mealsRepo.getMealById(id)
}