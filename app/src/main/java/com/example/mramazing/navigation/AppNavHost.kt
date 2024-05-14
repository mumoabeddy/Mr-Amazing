package com.example.mramazing.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hrent.screens.cover.Coverscreen
import com.example.mramazing.screens.home.HomeScreen
import com.example.mramazing.screens.login.LoginScreen
import com.example.mramazing.screens.payments.Paymentscreen
import com.example.mramazing.screens.payments.ViewUpdateScreen
import com.example.mramazing.screens.register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController= rememberNavController(),startDestination: String= ROUTE_COVER) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination){
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_COVER){
            Coverscreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)

        }

        composable(ROUTE_PAYMENTS){
            Paymentscreen(navController)
        }
        composable(ROUTE_VIEW_UPDATES){
            ViewUpdateScreen(navController)
        }

    }}