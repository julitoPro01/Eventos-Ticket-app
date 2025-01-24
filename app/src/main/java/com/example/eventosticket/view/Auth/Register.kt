package com.example.practic02.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.appticket.Navigate.NavigationRoute

import com.example.appticket.View.Auth.TextField_register
import com.example.eventosticket.R
import com.example.pruebas.DataModel.UsuarioModel
import com.example.pruebas.viewModel.UsuariosViewModel

//@Preview(showSystemUi = true)
@Composable
fun RegisterView(navController: NavHostController, viewModel: UsuariosViewModel) {
//fun RegisterView() {

    val usuario:UsuarioModel

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
    ){
        //--------TITULO------
        Image(
            painter = painterResource(id = R.drawable.fondologin),
            contentDescription = "evento",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 20.dp)
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
    //----------------------------
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 56.dp)

        ) {



            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(Color(0XFF3C47AE))
                        .padding(vertical =  20.dp, horizontal = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier


                    ) {
                        //----------btn INICIAR SESION
                        Button(onClick = {
                            navController.navigate(NavigationRoute.LoginView.route)
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color(0xFF6D78DB),

                                ),
                            modifier = Modifier
                                .offset(20.dp)

                        ) {
                            Text("Iniciar sesion",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            modifier = Modifier.padding(5.dp)
                                )
                        }

                        //---------btn REGISTRARSE
                        Button(onClick = {
                             navController.navigate(NavigationRoute.RegisterView.route)
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF6D78DB),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .offset(-20.dp)
                                .zIndex(1f)
                        ) {
                            Text("Registrarse",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                    //------------- TITULO
                    Text("Crear cuenta",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .align(Alignment.CenterHorizontally)

                        ,
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    //TEXT INPUT

                    TextField_register(navController,viewModel)

                    //btn CREAR CUENTA
                /*
                    Button(
                        onClick = {
                            navController.navigate(NavigationRoute.IndexView.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF6D78DB)
                        ),
                        modifier = Modifier
                            .padding(top =20.dp )


                    ) {
                        Text("Crear cuenta")
                    }
                    */
                }
            }

        }

    }
}

