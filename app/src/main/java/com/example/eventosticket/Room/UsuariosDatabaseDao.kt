package com.example.pruebas.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pruebas.DataModel.UsuarioModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuariosDatabaseDao {
    //GET (READ)
    @Query("select * from usuarios order by user asc")
    fun getUsers(): Flow<List<UsuarioModel>>

    //GET (READ) - SEARCH
    @Query("select * from usuarios where id = :id")
    fun getUserById(id:Int):Flow<UsuarioModel>

    @Query("SELECT * FROM usuarios WHERE email = :email")
    suspend fun getUserByEmail(email: String): UsuarioModel?

    @Query("SELECT * FROM usuarios WHERE password = :password")
    suspend fun getUserByPassword(password: String): UsuarioModel?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(usuario:UsuarioModel)

    @Update
    suspend fun updateUser(usuario: UsuarioModel)

    @Delete
    suspend fun deleteUser(usuario: UsuarioModel)
}