package com.meals.mealzapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meals.feature_category_list.meals.detail.MealDetailScreen
import com.meals.feature_category_list.meals.detail.MealDetailViewModel
import com.meals.feature_category_list.meals.list.MealsCategoriesScreen
import org.koin.androidx.compose.getStateViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MealApp() {
    val navControl = rememberNavController()

    NavHost(navControl, startDestination = NavigationKeys.MEAL_LIST) {
        composable(NavigationKeys.MEAL_LIST) {
            MealsCategoriesScreen {
                navControl.navigate("${NavigationKeys.MEAL_DETAIL}/$it")
            }
        }

        composable(
            "${NavigationKeys.MEAL_DETAIL}/{${NavigationKeys.MEAL_DETAIL_ARGUMENT}}",
            arguments = listOf(navArgument(NavigationKeys.MEAL_DETAIL_ARGUMENT) {
                type = NavType.StringType
            })
        ) {
            val parameters = it.arguments?.getString(NavigationKeys.MEAL_DETAIL_ARGUMENT)
            val viewmodel = getStateViewModel<MealDetailViewModel>(){
                parametersOf(parameters)
            }
            MealDetailScreen(viewmodel.mealState.value){
                navControl.navigate("${NavigationKeys.MEAL_DETAIL}/$it")
            }
        }
    }
}

object NavigationKeys {
    const val MEAL_DETAIL = "meal_detail"
    const val MEAL_LIST = "meal_list"
    const val MEAL_LIST_ARGUMENT = "meal_list_argument"
    const val MEAL_DETAIL_ARGUMENT = "meal_detail_argument"
}

