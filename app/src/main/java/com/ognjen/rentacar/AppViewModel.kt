package com.ognjen.rentacar

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.ognjen.common.service.UserService
import rs.ac.metropolitan.student.navigation.NavigationRoutes


class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController

    var userService = UserService()


    // Routing methods
    fun login(){
        navController.navigate(NavigationRoutes.Home.route)
    }

    fun register(){
        navController.navigate(NavigationRoutes.Login.route)
    }

    fun navigateToLogin(){
        navController.navigate(NavigationRoutes.Login.route)
    }
    fun navigateToRegister(){
        navController.navigate(NavigationRoutes.Register.route)
    }

    fun navigateToLocation(){
        navController.navigate(NavigationRoutes.Location.route)
    }

    fun navigateToAccount(){
        navController.navigate(NavigationRoutes.Account.route)
        userService.getById()
    }

    fun navigateToOrders(){
        navController.navigate(NavigationRoutes.Orders.route)
    }

    fun navigateToHome(){
        navController.navigate(NavigationRoutes.Home.route)
    }

    fun goBack() {
        navController.popBackStack()
    }
}