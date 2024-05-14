package com.example.wazitoecommerce.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.styleme.navigation.STARTER_URL
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {

        alpha.animateTo(0.7f,
            animationSpec = tween(2500))
        delay(3000)
        navController.popBackStack()
        navController.navigate(STARTER_URL)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffff9cce)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            LoaderAnimation(
                anim = R.raw.loader
            )
            Text(text = "style me",
                fontSize = 62.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(top = 250.dp)
                    .alpha(alpha.value),
                )
        }
        }
    }
@Composable
fun LoaderAnimation(anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever,
    ) }

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    WazitoECommerceTheme {
        SplashScreen(navController = rememberNavController())
    }
}