package com.meals.feature_category_list.meals.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.meals.domain.entity.Category
import com.meals.domain.entity.Meal
import com.meals.feature_category_list.meals.list.MealsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MealDetailScreen(meal: Category?,navigation:(mealId:String)->Unit) {

    val mealsViewModel= getViewModel<MealDetailViewModel>()
    val categoriesList = mealsViewModel.mealList.value

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        item(
            span = { GridItemSpan(2) }
        ) {
            CompositionLocalProvider(
                values = arrayOf(
                    LocalContentAlpha provides ContentAlpha.medium
                )
            ) {
                androidx.compose.material3.Text(
                    text = "Meals",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        items(categoriesList) { category: Meal ->
            MealCategory(meal = category,navigation)
        }
    }
//    LazyColumn {
//        items(categoriesList) { category: Meal ->
//            MealCategory(meal = category,navigation)
//        }
//    }
}

@Composable
fun MealCategory(meal: Meal, navigation: (mealId: String) -> Unit) {

    androidx.compose.material3.Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp)
            .clickable { navigation(meal.mealId) }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Image

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(meal.mealThumb)
                    .crossfade(true).build(),
                modifier = Modifier
                    .height(height = 85.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)), contentScale = ContentScale.Crop,
                contentDescription = "Meal "
            )


            CompositionLocalProvider(
                values = arrayOf(
                    LocalContentAlpha provides ContentAlpha.medium
                )
            ) {
                androidx.compose.material3.Text(
                    text = meal.mealName,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }

}

