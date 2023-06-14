package com.meals.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meals.core_ui.theme.MealzAppTheme
import com.meals.mealzapp.ui.navigation.MealApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealApp()
            }
        }
    }
}

