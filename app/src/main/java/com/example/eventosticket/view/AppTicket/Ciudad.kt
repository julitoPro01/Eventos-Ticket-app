package com.example.appticket.View.AppTicket

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventosticket.R

@Preview(showSystemUi = true)
@Composable
fun CiudadView(){
    data class itemsCategorias(val title01:String, val title02:String, @DrawableRes val img01:Int,@DrawableRes val img02:Int)
    data class itemsColors(val color01: Color, val color02: Color)

    val Items = listOf(
        itemsCategorias(title01 = "Lima", title02 = "Cuzco",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Puno", title02 = "Arequipa",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Piura", title02 = "Madre de dios",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Tacna", title02 = "Tumbes",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Loreto", title02 = "Lambayeque",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Ucayali", title02 = "La libertad",img01= R.drawable.evento01, img02=R.drawable.latino01),
        itemsCategorias(title01 = "Ica", title02 = "Huanuco",img01= R.drawable.evento01, img02=R.drawable.latino01)
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
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Colors[i % Colors.size].color01)

                    ) {

                        var item01 = Items[i]

                        Image(painter =
                            painterResource(item01.img01),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(150.dp)
                        )
                        Text("${item01.title01}",
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(Colors[i % Colors.size].color01)
                                .padding(10.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Colors[i % Colors.size].color02)

                    ) {
                        var item01 = Items[i]

                        Image(painter =
                        painterResource(item01.img01),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(150.dp)
                        )

                        Text("${item01.title02}",
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(Colors[i % Colors.size].color02)
                                .padding(10.dp),
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