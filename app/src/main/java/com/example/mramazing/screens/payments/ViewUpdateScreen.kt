package com.example.mramazing.screens.payments


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mramazing.data.PaymentsViewModel
import com.example.mramazing.module.Listing
import com.example.mramazing.navigation.ROUTE_PAYMENTS


//import com.example.hrent.navigation.ROUTE_UPDATE_PRODUCT


@Composable
fun ViewUpdateScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var paymentRepository = PaymentsViewModel<Any?>(navController, context)
        val emptyUploadState = remember { mutableStateOf(Listing.listing("", "", "", "", "")) }
        var emptyUploadsListState = remember { mutableStateListOf<Listing.listing>() }

        var payments = paymentRepository.viewUpdates(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))


            @Composable
            fun Updatepayment(name:String, house:String, data:String, profileUrl:String, id:String,
                              navController:NavHostController, productRepository:PaymentsViewModel<Any?>
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = name)
                    Text(text = house)
                    Text(text = data)
                    Image(
                        painter = rememberAsyncImagePainter(profileUrl),
                        contentDescription = null,
                        modifier = Modifier.size(128.dp)
                    )

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS + "/$id")
                    }) {
                        Text(text = "Update")
                    }
                }
            }}}}
