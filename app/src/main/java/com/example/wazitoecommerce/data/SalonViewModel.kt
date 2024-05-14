package com.example.wazitoecommerce.data



import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.styleme.navigation.LOGINO_URL
import com.example.wazitoecommerce.models.Product
import com.example.wazitoecommerce.models.Salon

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class SalonViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGINO_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadSalon(name:String, phonenumber:String, description:String, filePath:Uri){
        val salonId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Salons/$salonId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var salon = Product(name,phonenumber,description,imageUrl,salonId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Salons/$salonId")
                    databaseRef.setValue(salon).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allSalons(
        salon: MutableState<Salon>,
        salons: SnapshotStateList<Salon>
    ):SnapshotStateList<Salon>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Salons")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                salons.clear()
                for (snap in snapshot.children){
                    var retrievedSalon = snap.getValue(Salon::class.java)
                    salon.value = retrievedSalon!!
                    salons.add(retrievedSalon)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return salons
    }

    fun deleteSalon(SalonId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Salons/$SalonId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}



