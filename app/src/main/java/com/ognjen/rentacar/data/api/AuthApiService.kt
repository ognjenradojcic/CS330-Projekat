package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.request.LoginRequest
import com.ognjen.rentacar.data.dto.request.RefreshRequest
import com.ognjen.rentacar.data.dto.request.RegisterRequest
import com.ognjen.rentacar.data.dto.response.LoginResponse
import com.ognjen.rentacar.data.dto.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST(Constants.REGISTER_URL)
    suspend fun register(@Body registerRequest: RegisterRequest): UserResponse

    @POST(Constants.REFRESH_URL)
    suspend fun refreshToken(@Body refreshRequest: RefreshRequest): LoginResponse

}