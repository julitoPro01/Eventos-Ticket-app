package com.example.appticket.View.Auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appticket.Navigate.NavigationRoute
import com.example.pruebas.viewModel.UsuariosViewModel


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun textFiel_login(navController: NavHostController, viewModel: UsuariosViewModel) {

    var Hidden_pass= remember { mutableStateOf(true) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var msgError by remember { mutableStateOf("") }

      Column {

    TextField(
        value = email,
        onValueChange = {email = it},
        label = { Text("Correo Electronico", color = Color.Gray) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.Gray
        ),
        modifier = Modifier
        // .border(2.dp, Color.Red)

    )

    TextField(
        value = password,
        onValueChange = {password = it},
        label = { Text("Contraseña", color = Color.Gray) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.Gray
        ),
        trailingIcon = {
            IconButton(
                onClick = {Hidden_pass.value = !Hidden_pass.value}
            ) {
                Icon(imageVector = Icons.Default.Face,
                    contentDescription = null,
                    tint = Color.White
                    )

            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
            if(Hidden_pass.value) PasswordVisualTransformation()
            else VisualTransformation.None
    )
          Text(msgError, color = Color.Red)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {

            // USUARIO
          Button(
              onClick = {

                  if (email.isBlank() || password.isBlank() ) {
                      msgError = "Por favor, complete todos los campos"
                      return@Button
                  }
                  if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                      msgError = "El formato del correo no es válido"
                      return@Button
                  }

                  viewModel.validarUsuario(email,password,
                      onSuccess = {
                      navController.navigate(NavigationRoute.IndexView.route)
                     },
                      onError = { error ->
                          msgError = error
                      })

              },
              colors = ButtonDefaults.buttonColors(
                  containerColor = Color.White,
                  contentColor = Color(0xFF6D78DB)
              ),
              modifier = Modifier
                  .padding(top =20.dp )
                  .wrapContentWidth()

          ) {
              Text("Iniciar sesión")
          }
            //INVITADO
            Button(onClick = {
                navController.navigate(NavigationRoute.IndexView.route)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color(0xFF6D78DB)
                ),
                modifier = Modifier
                    .padding(top =20.dp )
                    .wrapContentWidth()

            ) {
                Text("Invitado")
            }
      }

    }
}



data class ObjValue(
    var Dni:String="",
    var Password:String=""

)


@Composable
fun FormInput(ObjValue:ObjValue):ObjValue{

    val TextValue = remember { mutableStateOf<ObjValue>(ObjValue) }
    return TextValue.value
}