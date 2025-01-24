package com.example.appticket.View.AppTicket

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun Pruebas(){

    data class views(val inicio:Boolean,val categoria:Boolean,val ticket:Boolean)

    var (state,setView) = remember { mutableStateOf(views(inicio = true, categoria = false, ticket = false)) }

    var isOk by remember { mutableStateOf("hello") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {


            Row(
                //horizontalArrangement = Arrangement.Center,
                modifier = Modifier

            ) {

                Text("Inicio", modifier = Modifier
                    .clickable {
                        setView(views(inicio = true, categoria = false, ticket = false))
                    })
                Spacer(Modifier.width(10.dp))
                Text("Categoria", modifier = Modifier
                    .clickable {
                        setView(views(inicio = false, categoria = true, ticket = false))
                    })
                Spacer(Modifier.width(10.dp))
                Text("Ticket")

            }

            if (state.inicio){
                Text("inicio")
            }
            else if(state.categoria){
                Text("categoria")
            }
            Text("Inicio: ${state.inicio} \n" +
                    "Categoria: ${state.categoria} \n" +
                    "ticket: ${state.ticket} -- ${isOk}" )

            Button(onClick = {
                setView(views(inicio = false, categoria = true, ticket = false))
                isOk = "ploper"
            }) {
                Text("hello")
            }

        }
        }
}
