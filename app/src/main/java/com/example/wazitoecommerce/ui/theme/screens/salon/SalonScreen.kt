package com.example.wazitoecommerce.ui.theme.screens.salon

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.data.SalonViewModel
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.home.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalonScreen(navController: NavHostController){


    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.LightGray) .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Book a slot",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        var name by remember { mutableStateOf("") }
        var phonenumber by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }


        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Full Name ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phonenumber,
            onValueChange = { phonenumber = it },
            label = { Text(text = "Phone Number ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description Details") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        ImagePicker(modifier,context, navController, name.trim(), phonenumber.trim(), description.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, phonenumber:String, description:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )
    Spacer(modifier = Modifier.height(200.dp))
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

            Column(modifier = modifier,) {
                if (hasImage && imageUri != null) {
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
                    Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {
                            imagePicker.launch("image/*")
                        },
                    ) {
                        Text(
                            text = "Select Image"
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = {
                        //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                        var salonRepository = SalonViewModel(navController, context)
                        salonRepository.uploadSalon(name, phonenumber, description, imageUri!!)


                    }) {
                        Text(text = "Upload")
                    }
                }
            }

    }
}





@Composable
@Preview(showBackground = true)
fun SalonScreenPreview(){
    WazitoECommerceTheme {
        SalonScreen(navController = rememberNavController())
    }
}









