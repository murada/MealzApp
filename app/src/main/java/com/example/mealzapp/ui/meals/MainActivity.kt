package com.example.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.model.response.MealCategoriesResponse
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                    MealsCategoriesScreen()
                
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen(modifier: Modifier = Modifier) {
        val mealsViewModel:MealsViewModel = viewModel()
        val rememberList:MutableState<List<CategoryResponse>> = remember {
            mutableStateOf(emptyList())
        }
         mealsViewModel.getMeals{response: MealCategoriesResponse? ->
            rememberList.value = response?.categoriesList.orEmpty()
        }

    LazyColumn {
        items(rememberList.value){category: CategoryResponse ->
            Text(text = category.categoryName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}