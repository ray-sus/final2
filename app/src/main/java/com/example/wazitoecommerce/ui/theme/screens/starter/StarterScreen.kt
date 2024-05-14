package com.example.wazitoecommerce.ui.theme.screens.starter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.styleme.navigation.LOGINO_URL
import com.example.wazitoecommerce.R

import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme


@Composable
fun StarterScreen(navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffff9cce))
    ) {
        Box (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hair))
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(300.dp) // Add a size modifier
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Welcome", fontWeight = FontWeight.ExtraBold, fontSize = 46.sp, fontFamily = FontFamily.Cursive)
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = "Hair saloon booking app", fontWeight = FontWeight.Bold, fontSize = 26.sp, fontFamily = FontFamily.Monospace)
            Text(text = "Book your spot now", fontWeight = FontWeight.Bold, fontSize = 26.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(200.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Button(onClick = {navController.navigate(LOGINO_URL) },
                modifier = Modifier
                .width(200.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                     Color(0xffB27FAC ),
                    contentColor = Color.Black
                )
            )
                {
                Text(text="Continue", fontWeight = FontWeight.Bold, fontSize = 20.sp) }
        }





    }
}






@Composable
@Preview(showBackground = true)
fun Preview(){
    WazitoECommerceTheme {
        StarterScreen(navController = rememberNavController())
    }
}