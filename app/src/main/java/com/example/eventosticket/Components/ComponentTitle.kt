package com.example.appticket.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventosticket.R

@Composable
fun ComponentTitle(){
    Image(
        painter = painterResource(id = R.drawable.fondologin),
        contentDescription = "evento",
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp),
        contentScale = ContentScale.Crop
    )

    Box(
        modifier = Modifier

    ){
        Column {

            Text("E-Ticke",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                modifier = Modifier
                    .offset(-40.dp)
            )
            Text("Teando",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                modifier = Modifier
                    .offset(40.dp)
            )
        }
    }
}