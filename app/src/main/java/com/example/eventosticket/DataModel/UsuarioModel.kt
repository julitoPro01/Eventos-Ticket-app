package com.example.pruebas.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UsuarioModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    val user:String,
    val email:String,
    val password:String,
    val numberPhone:Long
)
