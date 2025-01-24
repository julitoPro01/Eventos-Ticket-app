package com.example.eventosticket


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.appticket.Navigate.NavigateView
import com.example.eventosticket.ui.theme.EventosTicketTheme
import com.example.eventosticket.viewModel.EventsViewModel
import com.example.pruebas.Room.UsuariosDatabase
import com.example.pruebas.viewModel.UsuariosViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val database = Room.databaseBuilder(this, UsuariosDatabase::class.java, "db_usuarios")
                .fallbackToDestructiveMigration()
                .build()
            val dao = database.usuariosDao()
            val viewModel by viewModels<UsuariosViewModel>(factoryProducer = {
                object: ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass:Class<T>):T{
                        return  UsuariosViewModel(dao) as T
                    }
                }
            })

            val eventsViewModel: EventsViewModel by viewModels()

            EventosTicketTheme {
               NavigateView(viewModel,eventsViewModel = eventsViewModel)
                //EventList(eventsViewModel)
            }
        }
    }
}

