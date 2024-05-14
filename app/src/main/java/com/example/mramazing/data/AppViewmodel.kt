package com.example.mramazing.data



import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.mramazing.module.user
import com.example.mramazing.navigation.ROUTE_HOME
import com.example.mramazing.navigation.ROUTE_LOGIN
import com.example.mramazing.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AppViewModel(var navController: NavHostController, var context: Context){

    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val progress: ProgressDialog = ProgressDialog(context)

    init {
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }
    fun signup(email:String,phonenumber:String,Idnumber:String){
//            progress.show()

        if (email.isBlank() || phonenumber.isBlank() ||Idnumber.isBlank()){
//                progress.dismiss()
            Toast.makeText(context,"Please email and phonenumber cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (phonenumber != Idnumber){
            Toast.makeText(context,"One of the fields is incorrect",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,phonenumber).addOnCompleteListener { it ->
                if (it.isSuccessful){
                    val userdata= user(email,phonenumber,mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_HOME)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_REGISTER)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }
    fun login(email: String,pass: String){
//            progress.show()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
//                /progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)

            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}
