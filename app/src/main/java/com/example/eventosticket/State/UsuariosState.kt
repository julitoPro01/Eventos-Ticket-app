package com.example.pruebas.State


import com.example.pruebas.DataModel.UsuarioModel

data class UsuariosState (
    val listaUsuarios:List<UsuarioModel> = emptyList(),
    val Id:Int? = null,
    val User:String ="",
    val Email:String="",
    val Password: String="",
    val NumberPhone:Long=0
)

