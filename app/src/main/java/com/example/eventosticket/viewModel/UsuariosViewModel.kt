package com.example.pruebas.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebas.DataModel.UsuarioModel
import com.example.pruebas.Room.UsuariosDatabaseDao
import com.example.pruebas.State.UsuariosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UsuariosViewModel(
    private val UDao: UsuariosDatabaseDao
):ViewModel() {
    private var state by mutableStateOf(UsuariosState())
    var userName = mutableStateOf("")
    private  set

    //CONSTRUCTOR - GET
    init {
        viewModelScope.launch {
            UDao.getUsers().collectLatest {
                state = state.copy(
                    listaUsuarios = it
                )
            }
        }
    }

    //
    fun AddUser(usuario:UsuarioModel)=viewModelScope.launch {
        UDao.addUser(usuario = usuario)
        state = state.copy( // ----LIMPIAMOS ANTES DE AGREGAR
            User = "",
            Email = "",
            Password = "",
            NumberPhone = 0
        )
    }
    // BUSCAR USUARIO POR EMAIL
    fun getUserByEmail(email: String): UsuarioModel? = runBlocking {
        UDao.getUserByEmail(email)
    }

    fun getUserByPassword(password: String): UsuarioModel? = runBlocking {
        UDao.getUserByPassword(password)
    }
    // VALIDAR Y REGISTRAR
    fun registrarUsuario(
        usuario: UsuarioModel,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val existingUser = getUserByEmail(usuario.email)
                if (existingUser == null) {
                    AddUser(usuario)
                    updateUserName(usuario.user)
                    onSuccess()
                } else {
                    onError("El correo ya está registrado")
                }
            } catch (e: Exception) {
                onError("Ocurrió un error al registrar el usuario: ${e.message}")
            }
        }
    }

    fun validarUsuario(
        email:String,
        password:String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val existingUserByPassword = getUserByPassword(password)
                val existingUserByEmail = getUserByEmail(email)

                if (existingUserByEmail == null ) {

                    onError("Usuario / Contraseña incorrecta")
                } else {
                    if(existingUserByPassword == null){
                        onError("Usuario / Contraseña incorrecta")
                    }else{
                        onSuccess()
                        updateUserName(existingUserByEmail.user)
                    }

                }
            } catch (e: Exception) {
                onError("Ocurrió un error al consultar usuario: ${e.message}")
            }
        }
    }


    // ALMACENAR EL VALOR DEL USUARIO
    fun updateUserName(name: String) {
        userName.value = name
    }

    //
    fun UpdateUser(usuario:UsuarioModel)=viewModelScope.launch {
        UDao.updateUser(usuario = usuario)
        state = state.copy( // ----LIMPIAMOS ANTES DE AGREGAR
            Id = usuario.id,
            Email = usuario.email,
            Password = usuario.password,
            NumberPhone = usuario.numberPhone
        )
    }

    //
    fun DeleteUser(usuario: UsuarioModel)=viewModelScope.launch {
        UDao.deleteUser(usuario=usuario)
    }
}