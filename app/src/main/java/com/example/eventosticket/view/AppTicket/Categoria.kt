package com.example.appticket.View.AppTicket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Preview(showSystemUi = true)
@Composable
//fun miCategoria(navController: NavHostController) {
    fun miCategoria() {

    data class itemsCategorias(val title01:String,val title02:String)
    data class itemsColors(val color01:Color,val color02:Color)

        val Items = listOf(
            itemsCategorias(title01 = "Teatro", title02 = "Conciertos"),
            itemsCategorias(title01 = "Donaciones", title02 = "Ayuda Social"),
            itemsCategorias(title01 = "Ayuda Social", title02 = "Tecnologia"),
            itemsCategorias(title01 = "Cine", title02 = "Curso y Talleres"),
            itemsCategorias(title01 = "Stand Up", title02 = "Comunidad"),
            itemsCategorias(title01 = "Anime", title02 = "Viajes y Aventuras"),
            itemsCategorias(title01 = "Deportes", title02 = "Restaurante")
        )
        val Colors = listOf(
            itemsColors(color01 = Color(0xffFF6868), color02 = Color(0xff8BC570) ),
            itemsColors(color01 = Color(0xffC278D4), color02 = Color(0xffE0A25A) ),
            itemsColors(color01 = Color(0xff4CB2C0), color02 = Color(0xff6371EF) ),
            itemsColors(color01 = Color(0xff9543BC), color02 = Color(0xffA6B742) ),
            itemsColors(color01 = Color(0xff5F5F5F), color02 = Color(0xffDA3A74) ),
            itemsColors(color01 = Color(0xff487B36), color02 = Color(0xffAF4E4E) ),
            itemsColors(color01 = Color(0xff571B1B), color02 = Color(0xff3FC283) ),

        )

    LazyColumn {
        items(Items.size) { i ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    verticalAlignment = Alignment.CenterVertically   ) {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Colors[i % Colors.size].color01)

                    ) {
                        var item01 = Items[i]
                        var color01 = Colors[i]
                        Text("${item01.title01}",
                            modifier = Modifier,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Colors[i % Colors.size].color02)

                    ) {
                        var item01 = Items[i]
                        Text("${item01.title02}",
                            modifier = Modifier,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }


}
