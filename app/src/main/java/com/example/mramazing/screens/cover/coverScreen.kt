package com.example.hrent.screens.cover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.mramazing.R
import com.example.mramazing.navigation.ROUTE_REGISTER


@Composable
fun Coverscreen(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
        var productdata=(navController)

        Text(text = "HERE IS THE OFFER OF YOUR CHOICE!!!",
            color = Color.Black,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp)
        Box (modifier = Modifier
            .background(Color.LightGray)
            .width(400.dp)
            .height(200.dp)){
            Image(painter = painterResource(id = R.drawable.logo1),
                contentDescription ="Background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize())
            Text(modifier = Modifier
                .background(color = Color.Black)
                .padding(10.dp),
                text = "WE GOT EVERYTHING FOR YOU",
                color = Color.Cyan)


        }

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(modifier = Modifier
                .padding(10.dp),
                text = "GO TO REGISTER",
                color = Color.Black
            )
        }

        Box (modifier = Modifier
            .background(Color.LightGray)
            .width(400.dp)
            .height(200.dp)){
            Image(painter = painterResource(id = R.drawable.logo3),
                contentDescription ="FEEL AT HOME",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize())
            Text(text = "Enjoy yourself")



        }
        Box (modifier = Modifier
            .background(Color.LightGray)
            .width(400.dp)
            .height(200.dp)){
            Image(painter = painterResource(id = R.drawable.logo4),
                contentDescription ="Background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize())

            Text(text = "JUST HAVE A LOOK")


        }





    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoverScreenPreview(){
    Coverscreen(rememberNavController())

}



