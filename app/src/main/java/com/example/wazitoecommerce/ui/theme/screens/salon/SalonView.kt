package com.example.wazitoecommerce.ui.theme.screens.salon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wazitoecommerce.data.SalonViewModel
import com.example.wazitoecommerce.models.Salon

@Composable
fun SalonViewScreen(navController: NavHostController){
Column(modifier = Modifier.fillMaxSize(),
horizontalAlignment = Alignment.CenterHorizontally) {

    var context = LocalContext.current
    var salonRepository = SalonViewModel(navController, context)


    val emptySalonState = remember { mutableStateOf(Salon("","","","")) }
    var emptySalonsListState = remember { mutableStateListOf<Salon>() }

    var salons = salonRepository.allSalons(emptySalonState, emptySalonsListState)


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "All products",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red)

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(){

            items(salons){
                SalonItem(
                    name = it.name,
                    phonenumber = it.phonenumber,
                    description= it.description,
                    navController = navController,
                    salonRepository = salonRepository,
                    salonImage = it.imageUrl
                )
            }

            }
        }
    }
}



@Composable
fun SalonItem(name:String, description:String, phonenumber:String,
                navController: NavHostController,
                salonRepository:SalonViewModel, salonImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = phonenumber)
        Text(text = description)
        Image(
            painter = rememberAsyncImagePainter(salonImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )

        Button(onClick = {

            salonRepository.deleteSalon(name)
        }) {
            Text(text = "Delete")
        }

            Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ViewPrScreenPreview(){

        SalonViewScreen(navController = rememberNavController())
    }
