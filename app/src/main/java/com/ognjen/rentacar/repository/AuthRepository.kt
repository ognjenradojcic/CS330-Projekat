package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.AuthApiService
import com.ognjen.rentacar.data.dto.request.LoginRequest
import com.ognjen.rentacar.data.dto.request.RegisterRequest
import com.ognjen.rentacar.data.dto.response.LoginResponse
import com.ognjen.rentacar.data.dto.response.RegisterResponse
import com.ognjen.rentacar.data.exception.NotFoundException
import com.ognjen.rentacar.data.exception.UsedAttributeException

class AuthRepository {

    var loginResponse: LoginResponse? = null
    var registerResponse: RegisterResponse? = null

    var apiService = RetrofitHelper.getInstance().create(AuthApiService::class.java)

    suspend fun login(loginRequest: LoginRequest) {
        val response = apiService.login(loginRequest)
        if (response.isSuccessful) {
            loginResponse = response.body()
            RetrofitHelper.updateToken(loginResponse?.accessToken ?: "")

        } else {
            val errorBody = response.errorBody()?.string()
            when (response.code()) {
                400 -> {
                    throw NotFoundException("Incorrect credentials")
                }

                401 -> {
                    println("Ne moze")
                }

                404 -> {
                    throw NotFoundException("Incorrect credentials")
                }
                // Handle other error codes
                else -> {
                    println("Neuspesno")
                }
            }

        }
    }

    suspend fun register(registerRequest: RegisterRequest) {
        val response = apiService.register(registerRequest)
        if (response.isSuccessful) {
            registerResponse = response.body()

        } else {
            val errorBody = response.errorBody()?.string()
            when (response.code()) {
                400 -> {
                    println()
                    println("Neuspesno")
                }

                401 -> {
                    println("Neuspesno")
                }

                404 -> {
                    println("Neuspesno")
                }

                409 -> {
                    throw UsedAttributeException("Username is occupied")
                }
                // Handle other error codes
                else -> {
                    println("Neuspesno")
                }
            }
        }

    }
}