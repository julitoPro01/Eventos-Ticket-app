package com.example.appticket.View.AppTicket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventosticket.R

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun ComprarTicket(setView: (views) -> Unit) {

    var cuponValue by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
Column {


        Row(

            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(40.dp)

        ) {
            Button(onClick = {
                setView(views(inicio = true,
                    categoria = false,
                    ciudad = false, promociones = false,
                    showTopBar = true, bayTicket = false))
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
                ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)

                )
            }


            Text("Comprar entradas(s)",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier

            )
        }

        Column(
            Modifier.padding(vertical = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row {
                //DESCRIPTION
                Column(
                    modifier = Modifier.fillMaxWidth(.5f)
                ) {
                    Box{
                        Image(painterResource(id = R.drawable.image), contentDescription = null)
                    }
                    Text("Grupo 5 - chiclayo",Modifier
                        .padding(10.dp))
                    Row(Modifier) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(30.dp)
                        )
                        Text("Prolongación Bolognesi esquina" +
                                "con Vicente Russo 1400",
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(start = 5.dp))

                    }
                    Text("10/11/2024",Modifier.padding(10.dp))
                }

                //VENTA
                Column(Modifier.padding(end = 3.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF6A5ACD))

                    ){
                        Column() {
                            Text("GENERAL",
                                modifier = Modifier.fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .background(Color.White),
                                textAlign = TextAlign.Center,
                                color = Color.Blue)
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("-", textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .width(20.dp)
                                    .background(Color.White))
                                Text("2", color = Color.White, fontSize = 20.sp)
                                Text("+",textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width(20.dp)
                                        .background(Color.White))
                                Text("S/60.00", color = Color.White)
                            }
                            Text("Disponible: 20",modifier = Modifier
                                .fillMaxWidth().padding(vertical = 10.dp),
                                textAlign = TextAlign.Center,
                                color=Color.White)
                        }
                    }

                    Spacer(Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF6A5ACD))
                    ){
                        Column() {
                            Text("GENERAL",
                                modifier = Modifier.fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .background(Color.White),
                                textAlign = TextAlign.Center,
                                color = Color.Blue)
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("-", textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width(20.dp)
                                        .background(Color.White))
                                Text("2", color = Color.White, fontSize = 20.sp)
                                Text("+",textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width(20.dp)
                                        .background(Color.White))
                                Text("S/60.00", color = Color.White)
                            }
                            Text("Disponible: 20",modifier = Modifier
                                .fillMaxWidth().padding(vertical = 10.dp),
                                textAlign = TextAlign.Center,
                                color=Color.White)
                        }
                    }
                    Spacer(Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFF6A5ACD))

                    ){
                        Column() {
                            Text("GENERAL",
                                modifier = Modifier.fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .background(Color.White),
                                textAlign = TextAlign.Center,
                                color = Color.Blue)
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("-", textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width(20.dp)
                                        .background(Color.White))
                                Text("2", color = Color.White, fontSize = 20.sp)
                                Text("+",textAlign = TextAlign.Center,
                                    fontSize = 20.sp, modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .width(20.dp)
                                        .background(Color.White))
                                Text("S/60.00", color = Color.White)
                            }
                            Text("Disponible: 20",modifier = Modifier
                                .fillMaxWidth().padding(vertical = 10.dp),
                                textAlign = TextAlign.Center,
                                color=Color.White)
                        }
                    }

                }
            }
                //TITULO
            Box(Modifier.padding(vertical = 5.dp)) {
                Box( modifier =
                Modifier.fillMaxWidth()
                    .height(2.dp)
                    .background(Color.Blue)
                    .align(alignment = androidx.compose.ui.Alignment.BottomCenter)
                )
                Text("Finalizar Compra",
                    modifier = Modifier
                        .offset(x = 120.dp, y = 10.dp)
                        .background(Color(0xffDFF2EB)),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Blue)
            }

            ////////////////////////

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                // Input Cupon
                TextField(
                    value = cuponValue,
                    onValueChange = { cuponValue = it },
                    label = { Text("Cupon") },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xff00A0E6),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                         )

                Spacer(modifier = Modifier.height(16.dp))

                // Box Método de Pago
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF6A5ACD), RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Metodo de Pago",
                            color = Color.White,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        PaymentOption("Tarjeta debito o credito")
                        PaymentOption("Paypal")
                        PaymentOption("Yape")
                        PaymentOption("Plin")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Cantidad y Precio Total
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF6A5ACD), RoundedCornerShape(10.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Cantidad: 5",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Precio Total: S/100",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botón Realizar Compra
                Button(
                    onClick = { /* Acción de compra */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF6A5ACD)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Realizar Compra",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }

        }
    }


    }
}

@Composable
fun PaymentOption(optionText: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .height(40.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = optionText,
            color = Color(0xFF6A5ACD),
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 16.sp
        )
    }
}