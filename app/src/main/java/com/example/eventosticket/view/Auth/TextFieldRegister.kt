package com.example.appticket.View.Auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appticket.Navigate.NavigationRoute
import com.example.pruebas.DataModel.UsuarioModel
import com.example.pruebas.viewModel.UsuariosViewModel


@OptIn(ExperimentalMaterial3Api::class)
// @Preview(showSystemUi = true)
@Composable
fun TextField_register(navController: NavHostController, viewModel: UsuariosViewModel) {

    var user by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var numberPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password01 by remember { mutableStateOf("") }
    var msgError by remember { mutableStateOf("") }


    Column {

        TextField(
            value = user,
            onValueChange = {user = it},

            label = { Text("Nombre", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
        )

        TextField(
            value = email,
            onValueChange = {email=it},
            label = { Text("Correo electronico", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
        )
        TextField(
            value = numberPhone,
            onValueChange = {numberPhone=it},
            label = { Text("Numero de celular", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
        )

        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text("Contraseña", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            )
        )

        TextField(
            value = password01,
            onValueChange = {password01 = it},
            label = { Text("Repetir contraseña", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
        )

        //MSG ERROR
        Text(msgError,color = Color.Red)

        Button(
            onClick = {
                val phone = numberPhone.toLongOrNull() ?: 0L

                // Validar que todos los campos estén completos
                if (user.isBlank() || email.isBlank() || password.isBlank() || password01.isBlank()) {
                    msgError = "Por favor, complete todos los campos"
                    return@Button
                }

                // Validar que las contraseñas coincidan
                if (password != password01) {
                    msgError = "Las contraseñas no coinciden"
                    return@Button
                }

                // Validar formato del correo
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    msgError = "El formato del correo no es válido"
                    return@Button
                }

                // estados correctos.
                val usuario = UsuarioModel(
                    user = user,
                    email = email,
                    password = password,
                    numberPhone = phone
                )

                // Llama al ViewModel para registrar al usuario
                viewModel.registrarUsuario(
                    usuario,
                    onSuccess = {
                        navController.navigate(NavigationRoute.IndexView.route)
                    },
                    onError = { error ->
                        msgError = error
                    }
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF6D78DB)
            ),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Crear cuenta")
        }


    }
}