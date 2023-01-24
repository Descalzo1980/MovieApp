package ru.stas.movieapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.stas.movieapp.MainViewModel

@Composable
fun DetailsScreen(navController: NavController,viewModel: MainViewModel,itemId: String) {
    Text(text = "Details screen: item id $itemId")
}