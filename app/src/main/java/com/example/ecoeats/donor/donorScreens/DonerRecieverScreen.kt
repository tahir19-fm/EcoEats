package com.example.ecoeats.donor.donorScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecoeats.ui.theme.*

@Composable
fun DonerRecieverScreen(){

}
@Preview
@Composable
fun DonationList(){
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
                  Column {
                      FoodSourceName(source = "source_name")
                      FoodLocation(location = "food_location")
                      Row() {
                          FoodName("food_name")
                          FoodQuantity(quantity = "2 KG")
                      }
                      //button
                GenerateFunctionalButton(
                    text ="Donate" ,
                    horizontalPadding =20 ,
                    verticalPadding =10 ,
                    isEnabled = true ,
                    modifier =Modifier
                )
                  }
            FoodImageContainer()

        }
    }
}

@Composable
fun FoodSourceName(source : String){
    Text(text = source )
}

@Composable
fun GenerateFunctionalButton(
    text: String,
    horizontalPadding: Int,
    verticalPadding: Int,
    isEnabled: Boolean,
    modifier: Modifier,
    height : Int = 72,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .width(40.dp)
            .height(height.dp)
            .padding(horizontalPadding.dp, verticalPadding.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),

        colors = ButtonDefaults.buttonColors(backgroundColor = ActiveButtonColor),
        shape = RoundedCornerShape(10.dp),
        enabled = isEnabled
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White ,
//                fontFamily = FontFamilyAirLyft.regular,
                fontSize = 18.sp
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


