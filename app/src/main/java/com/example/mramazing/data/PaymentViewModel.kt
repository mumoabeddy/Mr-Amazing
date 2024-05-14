package com.example.mramazing.data


import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.mramazing.module.Listing
import com.example.mramazing.navigation.ROUTE_LOGIN
import com.example.mramazing.navigation.ROUTE_VIEW_UPDATES
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


//import com.google.firebase.storage.FirebaseStorage

class PaymentsViewModel<listing>(var navController: NavHostController, var context: Context) {
    var authRepository: AppViewModel = AppViewModel(navController, context)
    var progress: ProgressDialog

    init {
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun savePayment(tenantname:String, amountpayed:String, housename:String) {
        var id = System.currentTimeMillis().toString()
        var tenantsData =
            com.example.mramazing.module.payment.payment(tenantname, amountpayed, housename, id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(tenantsData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun payment(
        payment: String,
        payments: String,
        housename: String,
        id: String,
        data: String,
    ): String {
        val ref = FirebaseDatabase.getInstance().getReference().child("payments")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
//                payments.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(payment::class.java)
//                    payment.amount = value.toString()!!
                    if (value != null) {
//                        payments.add(value)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return payments
    }




    fun Updatepayment(name:String, housename: String, data:String, profileUrl:String, id:String, amountpayed:String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("payment/$id")
        progress.show()
        var updatepayment = payment(name, amountpayed, housename, id, data)
        updateRef.setValue(updatepayment).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun saveTenantWithImage(tenantname: String, housename: String, amount :String, filePath: Uri){
        var id = System.currentTimeMillis().toString()
        var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
        progress.show()

        storageReference.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Proceed to store other data into the db
                storageReference.downloadUrl.addOnSuccessListener {
                    var profileUrl = it.toString()
                    var Data = Listing.listing(
                        tenantname, housename,
                        amount, profileUrl, id
                    )
                    var dbRef = FirebaseDatabase.getInstance()
                        .getReference().child("Uploads/$id")
                    dbRef.setValue(Data)
                    Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_VIEW_UPDATES)
                }
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun viewUpdates(upload:MutableState<Listing.listing>, uploads:SnapshotStateList<Listing.listing>): SnapshotStateList<Listing.listing> {
        var ref = FirebaseDatabase.getInstance().getReference().child("listing" )

//        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                progress.dismiss()
                uploads.clear()
                for (snap in snapshot.children){
                    val value = snap.getValue(Listing.listing::class.java)
                    upload.value = value!!
                    uploads.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return uploads
    }



}
