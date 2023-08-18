package com.ognjen.data.service

import com.ognjen.data.Constants
import com.ognjen.data.dto.request.LoginRequest
import com.ognjen.data.dto.request.RefreshRequest
import com.ognjen.data.dto.request.RegisterRequest
import com.ognjen.data.dto.response.LoginResponse
import com.ognjen.data.dto.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST(Constants.REGISTER_URL)
    suspend fun register(@Body registerRequest: RegisterRequest): UserResponse

    @POST(Constants.REFRESH_URL)
    suspend fun refreshToken(@Body refreshRequest: RefreshRequest): LoginResponse

}