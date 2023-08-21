package com.ognjen.rentacar.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.ognjen.rentacar.data.dto.request.InvoiceRequest
import com.ognjen.rentacar.data.dto.request.LoginRequest
import com.ognjen.rentacar.data.dto.request.RegisterRequest
import com.ognjen.rentacar.data.dto.response.InvoiceResponse
import com.ognjen.rentacar.data.dto.response.ProductResponse
import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.data.exception.NotFoundException
import com.ognjen.rentacar.data.exception.UnauthorizedException
import com.ognjen.rentacar.data.exception.UsedAttributeException
import com.ognjen.rentacar.repository.AuthRepository
import com.ognjen.rentacar.repository.InvoiceRepository
import com.ognjen.rentacar.repository.ProductsRepository
import com.ognjen.rentacar.repository.UserRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import rs.ac.metropolitan.student.navigation.NavigationRoutes


class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController

    var granted = mutableStateOf(false)

    val userRepository = UserRepository()
    var userResponse: UserResponse? = null

    val productRepository = ProductsRepository()
    var products: List<ProductResponse>? = null

    val invoiceRepository = InvoiceRepository()
    var invoices: List<InvoiceResponse>? = null

    val authRepository = AuthRepository()

    private val _loginSuccessful = MutableStateFlow(true)
    val loginSuccessful: StateFlow<Boolean> = _loginSuccessful

    private val _registerSuccessful = MutableStateFlow(true)
    val registerSuccessful: StateFlow<Boolean> = _registerSuccessful

    fun fetchUser() {
        viewModelScope.launch {
            userRepository.getStudentById()
            MainScope().launch {
                userResponse = userRepository.userResponse
            }

        }
    }

    fun fetchProducts() {
        try {
            viewModelScope.launch {
                productRepository.getAll()
                MainScope().launch {
                    products = productRepository.products
                }
            }
        } catch (ex: UnauthorizedException) {
            println(ex.message)
        }
    }

    fun fetchInvoices() {
        try {
            viewModelScope.launch {
                invoiceRepository.getAll()
                MainScope().launch {
                    invoices = invoiceRepository.invoices
                }
            }
        } catch (ex: UnauthorizedException) {
            println(ex.message)
        }
    }

    // Routing methods
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                authRepository.login(loginRequest)
                _loginSuccessful.emit(true)
                fetchUser()
                navController.navigate(NavigationRoutes.Home.route)
            } catch (ex: NotFoundException) {
                _loginSuccessful.emit(false)
            }

        }

    }

    fun register(registerRequest: RegisterRequest) {

        viewModelScope.launch {
            try {
                authRepository.register(registerRequest)
                _registerSuccessful.emit(true)
                navController.navigate(NavigationRoutes.Login.route)
            } catch (ex : UsedAttributeException){
                _registerSuccessful.emit(false)
            }
        }
    }

    fun createInvoice(invoiceRequest: InvoiceRequest) {
        viewModelScope.launch {
            invoiceRepository.create(invoiceRequest)
            fetchInvoices()
            navController.navigate(NavigationRoutes.Orders.route)
        }
    }

    fun deleteInvoice(id: Int) {
        viewModelScope.launch {
            invoiceRepository.delete(id)
            fetchInvoices()
            navController.navigate(NavigationRoutes.Orders.route)
        }
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