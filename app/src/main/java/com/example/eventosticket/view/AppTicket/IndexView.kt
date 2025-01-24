package com.example.appticket.View.AppTicket

import android.icu.text.ListFormatter.Width
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appticket.Navigate.NavigationRoute

import com.example.appticket.View.AppTicket.Components.NavBar
import com.example.eventosticket.viewModel.EventsViewModel

 import com.example.pruebas.viewModel.UsuariosViewModel

data class views(val inicio:Boolean,val categoria:Boolean,
                 val ciudad:Boolean, val promociones:Boolean, val showTopBar:Boolean,
            val bayTicket:Boolean)

val colorActive = Color(0xffFFC94A)  // Color activo (amarillo)
val colorInactive = Color.White
//@Preview(showSystemUi = true)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun IndexView(navController: NavHostController, viewModel: UsuariosViewModel, eventsViewModel: EventsViewModel) {


    var (state,setView) = remember { mutableStateOf(
        views(inicio = true, categoria = false,
            ciudad = false, promociones = false, showTopBar = true,
            bayTicket=false
            )) }

    val username = viewModel.userName.value

    Scaffold(
        topBar = { if(state.showTopBar) miTopBar(navController,viewModel)},
        content = { innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding)) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffDFF2EB))
                ){

                    Column(
                        modifier = Modifier

                    ) {

                    //-----Menu------
                     if(state.showTopBar) NavBar(setView,state)
                    //---Contentidos----

                        when{
                            state.inicio ->  Inicio(navController, setView, eventsViewModel)
                            state.categoria ->  miCategoria()
                            state.ciudad ->  CiudadView()
                            state.promociones ->  PromocionesView()
                            state.bayTicket ->  ComprarTicket(setView)
                            else -> Inicio(navController, setView, eventsViewModel)
                        }
                    }

                }


            }
                  },
        bottomBar = { miBotomBar(navController, setView,state)},
        //floatingActionButton = {miBotonFlotante(navController)}
    )
}

@Composable
fun miBotomBar(navController: NavHostController, setView: (views) -> Unit, state: views) {
    BottomAppBar(
        modifier = Modifier,
        containerColor = Color(0xffDFF2EB),
        contentColor = Color(0xffffffff),
        actions = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()

            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFF08C2FF))
                ) {

                    //---ICON CART
                    IconButton(onClick = {
                        setView(views(inicio = false,
                            categoria = false,
                            ciudad = false, promociones = false,
                            showTopBar = false, bayTicket = true))
                    },
                        modifier = Modifier.padding(horizontal = 15.dp)
                        ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                                tint = if (state.bayTicket) colorActive else colorInactive,
                            )
                    }

                    //---ICON HOME
                    IconButton(onClick = {
                                setView(views(inicio = true,
                                    categoria = false,
                                    ciudad = false, promociones = false,
                                    showTopBar = true, bayTicket = false))
                                // navController.navigate(NavigationRoute.IndexCategory.route)
                           },
                        modifier = Modifier.padding(horizontal = 15.dp)

                        ) {
                        Icon(
                            tint = if (state.inicio) colorActive else colorInactive,
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }

                    //---ICON PERSON
                    IconButton(onClick = {

                    },
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                        ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                }
            }
        },
        tonalElevation = 5.dp
    )
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun miTopBar(navController: NavHostController, viewModel: UsuariosViewModel) {

    var menuExpanded by remember { mutableStateOf(false) } // Controla el estado del menú

    val username = viewModel.userName.value

    TopAppBar(
        modifier = Modifier
            .background(Color(0xff006BFF)),
        title = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Buscar", color = Color.Gray) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .height(40.dp)
                )

            }
        },
        colors = topAppBarColors(
            containerColor = Color(0xFFFFFFF),
            titleContentColor = Color(0xffffffff)
        ),
        // PERFIL
       actions = {
           IconButton(onClick = { menuExpanded = true }) {
               Column {
                   if(username.isBlank()){
                       Icon(
                     imageVector = Icons.Default.AccountCircle,
                     contentDescription = null,
                     tint = Color.Black,
                     modifier =  Modifier.size( if (viewModel.userName.value.isBlank() ) 60.dp else 60.dp )
                        )
                   }else{
                       Box(
                           modifier = Modifier

                               .clip(RoundedCornerShape(20.dp))
                               .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
                               .background(color = Color.Black)
                               .padding( 15.dp,5.dp)
                       ){
                           Text(  username.firstOrNull()?.uppercaseChar()?.toString() ?: "",
                               color = Color.White,
                               fontSize = 20.sp,
                               modifier = Modifier
                                   .padding(0.dp,2.dp)
                                   .offset(-3.dp,0.dp)
                           )
                       }
                   }

                   }

           }

           DropdownMenu(
               expanded = menuExpanded,
               onDismissRequest = { menuExpanded = false },
           ) {
               DropdownMenuItem(
                   text = { Text("Perfil") },
                   onClick = {
                       menuExpanded = false
                   }
               )
               DropdownMenuItem(
                   text = { Text("Ajustes") },
                   onClick = {
                       menuExpanded = false
                   }
               )

               // VALIDAR SI SE CERRO SESION
               if (username.isBlank()){
                   DropdownMenuItem(
                       text = { Text("Iniciar Sesión") },
                       onClick = {
                           menuExpanded = false

                           navController.navigate(NavigationRoute.LoginView.route)
                       }
                   )

                   DropdownMenuItem(
                       text = { Text("Registrarse") },
                       onClick = {
                           menuExpanded = false

                           navController.navigate(NavigationRoute.RegisterView.route)
                       }
                   )
               }else{
                   DropdownMenuItem(
                       text = { Text("Cerrar sesión") },
                       onClick = {
                           menuExpanded = false
                           viewModel.updateUserName("")
                       }
                   )
               }

           }
       }
    )
}
