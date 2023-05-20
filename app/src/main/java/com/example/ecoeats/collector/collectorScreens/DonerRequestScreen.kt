package com.example.ecoeats.collector.collectorScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecoeats.donor.donorScreens.*
import com.example.ecoeats.donor.donorScreens.HomeItemCard
import com.example.ecoeats.ui.theme.Green500
import com.example.ecoeats.ui.theme.Red500
@Preview
@Composable
fun DonerRequestScreen(){
   DonerListItem()
}

@Composable
fun DonerListItem(){
    LazyColumn(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), contentPadding = PaddingValues(bottom = 70.dp)
    ){
        item {
            Text(
                text = "Activity",
                modifier = Modifier.padding(10.dp, 5.dp),
                fontSize = 25.sp
            )
        }
        item { Spacer(modifier = Modifier.size(5.dp)) }
        items(10){
            DonerItemCard()
            Row {
                Spacer(modifier = Modifier.width(100.dp))
                Divider(
//                    Modifier.background(BottomLineColor),
                    thickness = 0.5.dp
                )
            }
        }

    }
}
@Composable
fun DonerItemCard(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .padding(6.dp)){
        Row (verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()){
            Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Start) {
                FoodImageContainer()
                Spacer(modifier = Modifier.size(10.dp))
                Column(modifier = Modifier.padding(5.dp)) {
                    //food source name
                    FoodName(name = "safjadsnfkjndsa")
                    FoodLocation(location = "afjhkjdfa asdkjfhaksdjfh dafdsfdsffffff")
                    Row(verticalAlignment = Alignment.CenterVertically ) {
                        FoodQuantity(quantity = "3 KG")
                        Spacer(modifier = Modifier.size(5.dp))
//                        FoodLifeBox(expired = false)
                    }
                }
            }
            MissonIcon(completed = true)
          
        }
    }
}

@Composable
fun MissonIcon(completed: Boolean , size: Int = 20 , iconSize : Int = 12,){

    Box(
        modifier = Modifier
            .size(size = size.dp)
            .aspectRatio(1f)
            .background(if (completed) Green500 else Red500, shape = CircleShape), contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (completed) Icons.Default.Check else  Icons.Default.Close ,
            contentDescription = "check_icon",
            modifier = Modifier.size(iconSize.dp)
        )
    }


}
