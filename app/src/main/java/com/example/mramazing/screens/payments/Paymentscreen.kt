package com.example.mramazing.screens.payments



import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mramazing.data.PaymentsViewModel
import com.example.mramazing.navigation.ROUTE_PAYMENTS
import com.example.mramazing.navigation.ROUTE_VIEW_UPDATES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paymentscreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "MAKE YOUR PAYMENTS",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Cyan,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var tenantName by remember { mutableStateOf(TextFieldValue("")) }
        var tenanthouse by remember { mutableStateOf(TextFieldValue("")) }
        var Amountpayed by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = tenantName,
            onValueChange = { tenantName = it },
            label = { Text(text = "Customer Name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = tenanthouse,
            onValueChange = { tenanthouse = it },
            label = { Text(text = "Customer ID *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = Amountpayed,
            onValueChange = { Amountpayed = it },
            label = { Text(text = "AMOUNT PAYED *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val paymentRepository = PaymentsViewModel<Any?>(navController,context)
            paymentRepository.savePayment(tenantName.text.trim(),tenanthouse.text.trim(),
                Amountpayed.text)
            navController.navigate(ROUTE_PAYMENTS)


        }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(20.dp))

        //---------------------IMAGE PICKER START-----------------------------------//

        ImagePicker(Modifier,context, navController, tenantName.text.trim(), tenanthouse.text.trim(), Amountpayed.text.trim())


    }
}
@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, house:String, amount: String,) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "profile image")
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "insert profile picture Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
//
            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var paymentsRepository = PaymentsViewModel<Any?>(navController,context)
                paymentsRepository.saveTenantWithImage(name,house,amount,imageUri!!)
                navController.navigate(ROUTE_VIEW_UPDATES)

            }) {
                Text(text = "Upload")
            }
            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//

                navController.navigate(ROUTE_VIEW_UPDATES)

            }) {
                Text(text = "view updates")
            }

        }
    }
}
@Preview
@Composable
fun AddProductsScreenPreview() {
    Paymentscreen(rememberNavController())

}

