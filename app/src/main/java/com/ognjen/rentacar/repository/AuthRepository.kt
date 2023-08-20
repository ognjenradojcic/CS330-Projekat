package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.AuthApiService
import com.ognjen.rentacar.data.dto.request.LoginRequest
import com.ognjen.rentacar.data.dto.request.RegisterRequest
import com.ognjen.rentacar.data.dto.response.LoginResponse
import com.ognjen.rentacar.data.dto.response.RegisterResponse

class AuthRepository {

    var loginResponse: LoginResponse? = null
    var registerResponse: RegisterResponse? = null

    var apiService = RetrofitHelper.getInstance().create(AuthApiService::class.java)

    suspend fun login(loginRequest: LoginRequest) {
        try {
            val response = apiService.login(loginRequest)
            if (response.isSuccessful) {
                loginResponse = response.body()
                RetrofitHelper.updateToken(loginResponse?.accessToken ?: "")

            } else {
                val errorBody = response.errorBody()?.string()
                when (response.code()) {
                    400 -> {
                        println("Neuspesno")
                    }

                    401 -> {
                        println("Neuspesno")
                    }

                    404 -> {
                        println("Neuspesno")
                    }
                    // Handle other error codes
                    else -> {
                        println("Neuspesno")
                    }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }

    }

    suspend fun register(registerRequest: RegisterRequest) {
        try {
            val response = apiService.register(registerRequest)
            if (response.isSuccessful) {
                registerResponse = response.body()

            } else {
                val errorBody = response.errorBody()?.string()
                when (response.code()) {
                    400 -> {
                        println("Neuspesno")
                    }

                    401 -> {
                        println("Neuspesno")
                    }

                    404 -> {
                        println("Neuspesno")
                    }
                    // Handle other error codes
                    else -> {
                        println("Neuspesno")
                    }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }

    }
}