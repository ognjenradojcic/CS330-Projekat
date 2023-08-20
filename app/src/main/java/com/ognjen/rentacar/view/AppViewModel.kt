package com.ognjen.rentacar.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.ognjen.rentacar.data.dto.request.LoginRequest
import com.ognjen.rentacar.data.dto.response.ProductResponse
import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.repository.AuthRepository
import com.ognjen.rentacar.repository.ProductsRepository
import com.ognjen.rentacar.repository.UserRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import rs.ac.metropolitan.student.navigation.NavigationRoutes


class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController

    var granted = mutableStateOf(false)

    val userRepository = UserRepository()
    var userResponse: UserResponse? = null

    val productRepository = ProductsRepository()
    var products : List<ProductResponse>? = null

    val authRepository = AuthRepository()


    fun fetchUser() {
        viewModelScope.launch {
            userRepository.getStudentById()
            MainScope().launch {
                userResponse = userRepository.userResponse
            }

        }
    }

    fun fetchProducts(){
        viewModelScope.launch {
            productRepository.getAll()
            MainScope().launch {
                products = productRepository.products
            }
        }
    }

    // Routing methods
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            authRepository.login(loginRequest)
        }

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