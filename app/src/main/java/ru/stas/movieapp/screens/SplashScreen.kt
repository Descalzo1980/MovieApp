package ru.stas.movieapp.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.stas.movieapp.navigation.Screens
import ru.stas.movieapp.ui.theme.MovieAppTheme

@Composable
fun SplashScreen(navController: NavController){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000),
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.navigate(Screens.Main.route)
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
    ){
        Icon(
           modifier = Modifier
               .size(120.dp)
               .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = Color.Black

        )
    }
}

@Composable
@Preview(showBackground = true)
fun prevSplash(){
    MovieAppTheme {
        Splash(1f)
    }
}