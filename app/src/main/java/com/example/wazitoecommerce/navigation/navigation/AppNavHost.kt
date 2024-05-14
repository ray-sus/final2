package com.example.styleme.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.SplashScreen
import com.example.wazitoecommerce.ui.theme.screens.home.HomeScreen
import com.example.wazitoecommerce.ui.theme.screens.logino.Logino
import com.example.wazitoecommerce.ui.theme.screens.products.AddProductsScreen
import com.example.wazitoecommerce.ui.theme.screens.products.ViewProductsScreen
import com.example.wazitoecommerce.ui.theme.screens.salon.SalonScreen
import com.example.wazitoecommerce.ui.theme.screens.salon.SalonViewScreen
import com.example.wazitoecommerce.ui.theme.screens.signo.Signo
import com.example.wazitoecommerce.ui.theme.screens.signup.SignupScreen
import com.example.wazitoecommerce.ui.theme.screens.starter.StarterScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){


    NavHost(
        navController, startDestination, modifier
    ){
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }

        composable(SALON_URL){
            SalonScreen(navController = navController)
        }

        composable(SALONVIEW_URL){
            SalonViewScreen(navController = navController)
        }

        composable(STARTER_URL){
            StarterScreen(navController = navController)
        }

        composable(SIGNO_URL){
            Signo(navController = navController)
        }

        composable(LOGINO_URL){
            Logino(navController = navController)
        }
        composable(LOGIN_URL){
            Logino(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOMESCREEN_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }
    }
}