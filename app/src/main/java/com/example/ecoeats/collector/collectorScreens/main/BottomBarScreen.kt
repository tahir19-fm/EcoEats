package com.example.ecoeats.collector.collectorScreens.main

import androidx.annotation.DrawableRes
import com.example.ecoeats.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes val iconFilled: Int,
    @DrawableRes val iconOutlined:Int
){
    object Home : BottomBarScreen(route = "home" , "Home", R.drawable.home_solid,R.drawable.home_outline)
    object History : BottomBarScreen(route = "history" , "Activity" ,R.drawable.inbox_arrow_down_solid,R.drawable.inbox_arrow_down_outline)
}