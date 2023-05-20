package com.example.ecoeats.collector.collectorNavigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.example.ecoeats.collector.collectorScreens.main.MainScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(){
    val navController= rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, route =Graph.Bottom, startDestination =Graph.Root){
        composable(route = Graph.Root){
            MainScreen()
        }
    }
}