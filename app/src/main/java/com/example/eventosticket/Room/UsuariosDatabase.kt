package com.example.pruebas.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebas.DataModel.UsuarioModel

@Database(
    entities = [UsuarioModel::class],
    version = 2,
    exportSchema = false
)

abstract class UsuariosDatabase:RoomDatabase() {
    abstract fun usuariosDao():UsuariosDatabaseDao
}