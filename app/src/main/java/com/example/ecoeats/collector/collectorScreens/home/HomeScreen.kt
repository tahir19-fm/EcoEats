package com.example.ecoeats.collector.collectorScreens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecoeats.collector.components.ItemCard

@Composable
fun HomeScreen(){
Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            items(10){
                ItemCard()
            }
        }
}
}

