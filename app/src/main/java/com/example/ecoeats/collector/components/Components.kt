package com.example.ecoeats.collector.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ecoeats.R
import com.example.ecoeats.utils.FontFamilyEcoEats

@Composable
fun ItemCard(){

    Card(modifier = Modifier.wrapContentSize().padding(vertical = 10.dp, horizontal = 10.dp), shape = RoundedCornerShape(12.dp), elevation = 4.dp) {


        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://media.cnn.com/api/v1/images/stellar/prod/140430115517-06-comfort-foods.jpg?q=w_1080,h_720,x_100,y_0,c_crop")
                        .allowHardware(false)
                        .build()
                ),
                contentDescription = "book image",
                modifier = Modifier
                    .size(50.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
                    .weight(0.9f)
            ) {
                Text(
                    "Food Source",
                    style = TextStyle(
                        fontFamily = FontFamilyEcoEats.bold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Text(
                    "Food Source",
                    style = TextStyle(
                        fontFamily = FontFamilyEcoEats.ultraLight,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                )
                Text(
                    "30 kg",
                    style = TextStyle(
                        fontFamily = FontFamilyEcoEats.ultraLight,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                )

            }
            Icon(
                Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )

        }
    }
}
