package com.example.appticket.View.Auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appticket.Navigate.NavigationRoute
import com.example.eventosticket.R
import com.example.pruebas.viewModel.UsuariosViewModel


//@Preview(showSystemUi = true)
@Composable
fun MainAuth(navController: NavHostController, viewModel: UsuariosViewModel) {
  //  fun MainAuth() {

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding()
    ){
        Image(
            painter = painterResource(id = R.drawable.fondologin),
            contentDescription = "evento",
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp),
                  contentScale = ContentScale.Crop
        )

        //TITULO
        Box(
            modifier = Modifier
                .align(Alignment.Center)
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                navController.navigate(NavigationRoute.LoginView.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3742AC)
            )
            ) {
                 Text("Iniciar sesión")
             }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                Text("¿No tienes una cuenta? ", color = Color.Gray)
                Text("Crear cuenta",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationRoute.RegisterView.route)
                        },
                    color = Color.White,
                    )
            }

             Spacer(modifier = Modifier.height(100.dp))
    }
    }
}