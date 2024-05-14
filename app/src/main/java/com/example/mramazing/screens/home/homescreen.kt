package com.example.mramazing.screens.home

import com.example.mramazing.R
import com.example.mramazing.navigation.ROUTE_HOME
import com.example.mramazing.navigation.ROUTE_PAYMENTS



import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    Column (modifier = Modifier.fillMaxWidth(),
    ){
        OutlinedTextField(
            value = "",
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon",modifier=Modifier.clickable {  navController.navigate(ROUTE_HOME) { popUpTo(
                ROUTE_HOME)} }) },
            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
            onValueChange = {

            },
            label = { Text(text = "Search places") },
            placeholder = { Text(text = "Search places") },
            modifier = Modifier
                .background(Color.Black)
                .width(400.dp)
                .height(60.dp)
        )

    }


    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        val mContext = LocalContext.current

        Row(
            modifier = Modifier.padding(start = 20.dp)
        ) {


            Column {

                Spacer(modifier = Modifier.height(60.dp))
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo1),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }


                }



                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.15000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            //End of Column1
            Spacer(modifier = Modifier.width(10.dp))

            //Column1

            Column {
                Spacer(modifier = Modifier.height(60.dp))
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo10),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.20000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            //End of Column1
        }
        Row(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo6),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.10000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            //End of Column1
            Spacer(modifier = Modifier.width(10.dp))

            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo4),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = " ",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.25000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))


        }
        Row(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo3),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.22000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            //End of Column1
            Spacer(modifier = Modifier.width(10.dp))

            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo1),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Button(onClick = {
                        navController.navigate(ROUTE_PAYMENTS)
                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                        modifier = Modifier.width(160.dp),
                    ) {
                        Text(modifier = Modifier
                            .padding(4.dp),
                            text ="MAKEPAYMENT",
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = " ",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.20000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))


        }
        Row(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo8),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.15000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            //End of Column1
            Spacer(modifier = Modifier.width(10.dp))

            //Column1

            Column {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(160.dp)

                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo8),
                            contentDescription = "car10",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(15.dp)
                        )

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = " ",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "FOR Ksh.17000",
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    OutlinedButton(
                        onClick = {

                            val callIntent=Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0746434045".toUri()
                            mContext.startActivity(callIntent)

                        },

                        ) {
                        Text(text = "Call", color = Color.Black)

                    }
                    OutlinedButton(
                        onClick = {

                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hilarywambua67@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)



                        },

                        ) {
                        Text(text = "email", color = Color.Black)

                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))


        }

    }

}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Login(){
    HomeScreen(rememberNavController())
}