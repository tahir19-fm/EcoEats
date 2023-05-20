package com.example.ecoeats.collector.collectorNavigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.ecoeats.collector.collectorScreens.home.HomeScreen
import com.example.ecoeats.collector.collectorScreens.main.BottomBarScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavGraph(navController: NavHostController) {
    AnimatedNavHost(navController=navController,route =Graph.Home, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
               HomeScreen()
        }
        composable(route = BottomBarScreen.History.route){
            Text(text = "dsdsdsdsdsdsd")
        }
    }
}
object Graph{
    const val Root = "root_graph"
    const val Authentication = "auth_graph"
    const val Home = "home_graph"
    const val Account = "account_graph"
    const val Profile = "profile_graph"
    const val Bottom = "bottom_graph"
    const val Splash="splash_graph"
}