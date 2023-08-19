package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET(Constants.USERS_URL)
    suspend fun getAll(): List<UserResponse>

    @GET(Constants.USERS_URL + "/{id}")
    suspend fun getById(@Path("id") id: Int): UserResponse

}