package com.example.wazitoecommerce.ui.theme.screens.logino

import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.styleme.navigation.HOMESCREEN_URL
import com.example.styleme.navigation.SIGNO_URL
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Logino(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffBB8FCE)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            LottieAnimationView(R.raw.logi)
        }
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Login to your account", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Email address")
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password, onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
            visualTransformation = PasswordVisualTransformation(),)

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xC1803E8B))
            ) {
                Text(text = "Login")
            }
Spacer(modifier = Modifier.width(7.dp))

            Button(
                onClick = { navController.navigate(HOMESCREEN_URL) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xC1803E8B))
            ) {
                Text(text = "Guest")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Or sign in with")
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "google",
                modifier = Modifier
                    .size(45.dp)
                    .clickable { }
                )
            }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Create new account",fontWeight = FontWeight.SemiBold,modifier = Modifier.clickable { navController.navigate(SIGNO_URL) })
    }
        }



@Composable
fun LottieAnimationView(
    @RawRes animationResId: Int,
    modifier: Modifier = Modifier,
    iterations: Int = LottieConstants.IterateForever,
    isPlaying: Boolean = true,
    speed: Float = 1f,
    contentScale: ContentScale = ContentScale.Fit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationResId))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = iterations,
        isPlaying = isPlaying,
        speed = speed
    )
    LottieAnimation(
        composition,
        progress,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
@Preview(showBackground = true)
fun LoginoPreview(){
    WazitoECommerceTheme {
        Logino(navController = rememberNavController())
    }
}