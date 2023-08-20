package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.request.UserRequest
import com.ognjen.rentacar.data.dto.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApiService {

    @GET(Constants.USERS_URL)
    suspend fun getAll(): List<UserResponse>

    @GET(Constants.USERS_URL + "/profile")
    suspend fun getProfile(@Header("Authorization") authHeader: String): UserResponse

    @POST(Constants.USERS_URL + "/{id}")
    suspend fun update(@Path("id") id: Int, @Body user: UserRequest)
}