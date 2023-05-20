package com.example.ecoeats.collector.collectorScreens.main

 import android.annotation.SuppressLint
 import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
 import androidx.compose.foundation.ExperimentalFoundationApi
 import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.text.TextStyle
 import androidx.compose.ui.unit.sp
 import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
 import com.example.ecoeats.collector.collectorNavigation.BottomNavGraph
 import com.example.ecoeats.collector.collectorNavigation.HomeNavGraph
 import com.example.ecoeats.utils.FontFamilyEcoEats
 import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavHostController = rememberAnimatedNavController()){
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("screernffjj", "${navBackStackEntry?.destination?.route} ")
    when (navBackStackEntry?.destination?.route) {
        "home"->{
            bottomBarState.value=true
        }
        "history"->{
            bottomBarState.value=true
        }
        "account"->{
            bottomBarState.value=true
        }
        else->{
            bottomBarState.value=false
        }
    }

   Scaffold( bottomBar = {
        BottomBar(
            navController = navController,
            bottomBarState=bottomBarState
        )
    }) {

           HomeNavGraph(navController = navController)


    }

}

@Composable
fun BottomBar(navController: NavHostController, bottomBarState: MutableState<Boolean>){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.History)


    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
          BottomBarScreenContent(navController = navController, bottomBarState = bottomBarState,screens=screens)
        })
    }




private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}

@Composable
fun BottomBarScreenContent(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>,
    screens: List<BottomBarScreen>
){

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            // this is a row scope
            // all items are added horizontally
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            screens.forEach { menuItem ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == menuItem.route } == true

                // adding each item
                BottomNavigationItem(
                    selected = (selected),
                    onClick = {
                        if (selected) return@BottomNavigationItem
                        navController.navigate(menuItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painterResource(id = if (selected) menuItem.iconFilled else menuItem.iconOutlined),
                            contentDescription = menuItem.route
                        )
                    },
                    label = {
                        Text(text = menuItem.title, style = TextStyle(fontFamily =if(selected) FontFamilyEcoEats.medium else FontFamilyEcoEats.regular, fontSize = 14.sp))
                    },
                    enabled = true
                )
            }
        }
    }
}