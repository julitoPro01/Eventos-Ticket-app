package com.example.appticket.View.AppTicket.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appticket.View.AppTicket.colorActive
import com.example.appticket.View.AppTicket.colorInactive
import com.example.appticket.View.AppTicket.views

@Composable
fun NavBar(setView: (views) -> Unit, state: views) {
    Box(
        modifier = Modifier.background(Color(0xff7AB2D3))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                // .clip(RoundedCornerShape(16.dp))
                .background(Color(0xff08C2FF))
                .padding(10.dp)
        ) {

            Text("Categoria",
                color =if (state.categoria) colorActive else colorInactive ,
                fontWeight = if (state.categoria) FontWeight.Bold else FontWeight.Light,
                fontSize = 15.sp,
                modifier = Modifier
                    .clickable {
                        setView(views(
                            inicio = false,
                            categoria = true,
                            ciudad = false,
                            promociones = false,
                            showTopBar = true, bayTicket = false))

                        // navController.navigate(NavigationRoute.IndexCategory.route)
                    }
            )
            Text("Ciudad",color = if (state.ciudad) colorActive else colorInactive,
                fontWeight = if (state.ciudad) FontWeight.Bold else FontWeight.Light,
                modifier = Modifier
                    .clickable {
                        setView(views(inicio = false,
                            categoria = false,
                            ciudad = true,
                            promociones = false,
                            showTopBar = true,
                            bayTicket = false
                            ))
                        // navController.navigate(NavigationRoute.IndexCategory.route)
                    }
                )
            Text("Promociones",color = if (state.promociones) colorActive else colorInactive,
                fontWeight = if (state.promociones) FontWeight.Bold else FontWeight.Light,
                modifier = Modifier
                    .clickable {
                        setView(views(inicio = false,
                            categoria = false,
                            ciudad = false,
                            promociones = true,
                            showTopBar = true,
                            bayTicket = false))
                        // navController.navigate(NavigationRoute.IndexCategory.route)
                    })
        }
    }
}