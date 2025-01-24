package com.example.appticket.Navigate

sealed class NavigationRoute(val route:String) {
    object LoginView:NavigationRoute("login")
    object RegisterView:NavigationRoute("register")
    object Auth:NavigationRoute("auth")
    object IndexView:NavigationRoute("index")

    object IndexCategory:NavigationRoute("category")
    object IndexHome:NavigationRoute("home")

}