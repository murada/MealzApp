package com.example.mealzapp.ui.meals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.mealzapp.model.response.CategoryResponse
import com.example.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsCategoriesScreen(modifier: Modifier = Modifier) {
    val mealsViewModel: MealsViewModel = viewModel()
    val categoriesList = mealsViewModel.categoriesState.value
    LazyColumn {
        items(categoriesList) { category: CategoryResponse ->
            MealCategory(mealCategory = category)
        }
    }
}

@Composable
fun MealCategory(mealCategory: CategoryResponse) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            //Image

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mealCategory.categoryUrlImage)
                    .crossfade(true).build(),
                modifier = Modifier
                    .size(85.dp)
                    .clip(CircleShape), contentScale = ContentScale.Crop,
                contentDescription = "Meal "
            )
            Column {

                CompositionLocalProvider(
                    values = arrayOf(
                        LocalContentAlpha provides ContentAlpha.medium
                    )
                ) {
                    Text(
                        text = mealCategory.categoryName,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }

                CompositionLocalProvider(
                    values = arrayOf(
                        LocalContentAlpha provides ContentAlpha.disabled
                    )
                ) {
                    Text(
                        text = mealCategory.categoryDescription,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }

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