package com.ognjen.data.service

import com.ognjen.data.Constants
import com.ognjen.data.dto.response.UserResponse
import retrofit2.http.GET

interface UserService {

    @GET(Constants.USERS_URL)
    suspend fun getAll(): List<UserResponse>



}