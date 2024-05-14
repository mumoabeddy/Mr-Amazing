package com.example.mramazing.screens.register



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.BoxScopeInstance.matchParentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.mramazing.R
import com.example.mramazing.data.AppViewModel
import com.example.mramazing.navigation.ROUTE_HOME
import com.example.mramazing.navigation.ROUTE_LOGIN


@Composable
fun RegisterScreen(navController: NavHostController) {
    var phonenumber by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var Idnumber by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(modifier = Modifier
        .background(color = Color.Yellow)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "DO YOUR REGISTRATION",
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phonenumber, onValueChange = { phonenumber = it },
            label = { Text(text = "Please enter your phone number") },

            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(text = "please enter your email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =Idnumber , onValueChange = {
            Idnumber=it},
            label = { Text(text = "Please Enter your Id number") },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
//
        Button(onClick = {
            val myregister = AppViewModel(navController,context)
            myregister.signup(email.text.trim(), phonenumber.text.trim(), Idnumber.text.trim())
            navController.navigate(ROUTE_HOME)

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = " Click to Login")
        }
        Image(painter = painterResource(id = R.drawable.logo2),
            contentDescription ="Background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxHeight())

    }



}

@Preview
@Composable
fun RegisterScreen() {
    RegisterScreen(rememberNavController())

}