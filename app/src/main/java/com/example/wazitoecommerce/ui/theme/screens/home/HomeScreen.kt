package com.example.wazitoecommerce.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.styleme.navigation.ADD_PRODUCTS_URL
import com.example.styleme.navigation.HOMESCREEN_URL
import com.example.styleme.navigation.SALON_URL
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(2, 0, 36),
            Color(121, 9, 112),
            Color(0, 212, 255)
        ),
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(

          
            bottomBar = {
                NavigationBar  (modifier = Modifier.background(color = Color.Black)){
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = {  }) {
                    IconButton(onClick = {navController.navigate(ADD_PRODUCTS_URL) }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable {

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .background(brush = gradient)) {
                        Box (
                            modifier = Modifier.fillMaxWidth(),

                        ) {

                                Column {

                                    Text(
                                        text = "STYLE ME",
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        style = TextStyle(
                                            fontSize = 24.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            fontFamily = FontFamily.Monospace
                                        )
                                    )
                                }

                        }

                    Card(
                        shape = RoundedCornerShape(18.dp), // This gives the card rounded corners
                        modifier = Modifier.padding(18.dp)
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.styy),
                                contentDescription = ""
                            )
                            Text(
                                text = "GET 10% OFF AFTER REGISTERING",
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(30.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color.White
                            )
                        }

                    }
                        Column {
                            Text(text = "what we offer",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 8.dp)
                                        .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Color.LightGray)
                        }
                        Row (
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        )

                        {
                            Column(
                                modifier = Modifier.weight(0.25f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(painter = painterResource(id = R.drawable.pedicure), contentDescription ="",
                                    Modifier
                                        .clickable { navController.navigate(SALON_URL) }
                                        .height(100.dp)
                                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                                        .padding(top = 8.dp, bottom = 4.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(16.dp))
                                Text(text = "Money&Pedicure",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 8.dp),
                                    color = Color.White

                                    )
                            }
                            Column(
                                modifier = Modifier.weight(0.25f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(painter = painterResource(id = R.drawable.facebrush), contentDescription ="",
                                    Modifier
                                        .clickable {  navController.navigate(SALON_URL) }
                                        .height(100.dp)
                                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                                        .padding(top = 8.dp, bottom = 4.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(16.dp))
                                Text(text = "Full makeup",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 8.dp),
                                    color = Color.White)
                            }
                            }

                        Row (
                            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        )

                        {
                            Column(
                                modifier = Modifier.weight(0.25f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(painter = painterResource(id = R.drawable.facialtreatment), contentDescription ="",
                                    Modifier
                                        .clickable { navController.navigate(SALON_URL)  }
                                        .height(100.dp)
                                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                                        .padding(top = 8.dp, bottom = 4.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(16.dp))
                                Text(text = "Face treatement",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 8.dp),
                                    color = Color.White)
                            }
                            Column(
                                modifier = Modifier.weight(0.25f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(painter = painterResource(id = R.drawable.haircut), contentDescription ="",
                                    Modifier
                                        .clickable {  navController.navigate(SALON_URL) }
                                        .height(100.dp)
                                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                                        .padding(top = 8.dp, bottom = 4.dp)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .padding(16.dp))
                                Text(text = "Hair style",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 8.dp),
                                    color = Color.White)
                            }
                        }



                        }





            }
        )
    }
}




val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Login",
        route="salonview",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = false,
        badges=0
    )


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}