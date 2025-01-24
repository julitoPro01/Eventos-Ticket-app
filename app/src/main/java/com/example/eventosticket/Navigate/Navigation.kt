package com.example.appticket.Navigate

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appticket.View.Auth.MainAuth
import com.example.appticket.View.AppTicket.IndexView
import com.example.appticket.View.AppTicket.Inicio

import com.example.eventosticket.viewModel.EventsViewModel
import com.example.practic02.View.LoginView
import com.example.practic02.View.RegisterView
import com.example.pruebas.viewModel.UsuariosViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigateView(viewModel:UsuariosViewModel, eventsViewModel: EventsViewModel) {
    val navController = rememberNavController()
    val username = viewModel.userName.value

    NavHost(navController = navController, startDestination = NavigationRoute.Auth.route){
        composable(NavigationRoute.Auth.route) { MainAuth(navController=navController, viewModel = viewModel)  }
        composable(NavigationRoute.LoginView.route) { if(username.isBlank()) LoginView(navController=navController, viewModel = viewModel) else IndexView(navController=navController, viewModel = viewModel, eventsViewModel=eventsViewModel)  }
        composable(NavigationRoute.RegisterView.route) { if (username.isBlank()) RegisterView(navController=navController, viewModel = viewModel )  else IndexView(navController=navController, viewModel = viewModel, eventsViewModel=eventsViewModel) }
        composable(NavigationRoute.IndexView.route) { IndexView(navController=navController, viewModel = viewModel, eventsViewModel=eventsViewModel)  }
          composable (NavigationRoute.IndexHome.route ) { Inicio(
            navController=navController,
            setView = null,
              eventsViewModel=eventsViewModel
        ) }

    }
}