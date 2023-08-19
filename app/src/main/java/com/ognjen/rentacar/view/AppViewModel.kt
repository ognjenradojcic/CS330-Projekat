package com.ognjen.rentacar.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import rs.ac.metropolitan.student.navigation.NavigationRoutes


class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController

    var granted = mutableStateOf(false)
    val repository = UserRepository()

    private val _user = MutableStateFlow<UserResponse?>(null)
    val user: StateFlow<UserResponse?> = _user

    fun fetchUser() {
        viewModelScope.launch {
            val fetchedUser = repository.getStudentById()
            _user.value = fetchedUser
        }
    }

    // Routing methods
    fun login() {
        navController.navigate(NavigationRoutes.Home.route)

    }

    fun register() {
        navController.navigate(NavigationRoutes.Login.route)
    }

    fun navigateToLogin() {
        navController.navigate(NavigationRoutes.Login.route)
    }

    fun navigateToRegister() {
        navController.navigate(NavigationRoutes.Register.route)
    }

    fun navigateToLocation() {
        navController.navigate(NavigationRoutes.Location.route)
    }

    fun navigateToAccount() {
        navController.navigate(NavigationRoutes.Account.route)
    }

    fun navigateToOrders() {
        navController.navigate(NavigationRoutes.Orders.route)
    }

    fun navigateToHome() {
        navController.navigate(NavigationRoutes.Home.route)
    }

    fun goBack() {
        navController.popBackStack()
    }
}