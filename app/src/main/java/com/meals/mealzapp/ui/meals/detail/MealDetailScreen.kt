package com.meals.mealzapp.ui.meals.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.meals.domain.entity.Category
import com.meals.mealzapp.model.response.CategoryResponse

@Composable
fun MealDetailScreen(meal: Category?) {
    Column {
        Row {
            Card {
                Image(
                    painter=  rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(meal?.categoryUrlImage).
                    build()),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(meal?.categoryName?: "default name")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Change state of meal profile picture")
        }
    }
}