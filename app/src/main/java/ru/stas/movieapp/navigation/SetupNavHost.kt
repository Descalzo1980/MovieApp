package ru.stas.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.stas.movieapp.MainViewModel
import ru.stas.movieapp.screens.MainScreen
import ru.stas.movieapp.screens.SplashScreen
import ru.stas.movieapp.utils.Constants

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = Screens.Details.route) {
        }
    }
}
