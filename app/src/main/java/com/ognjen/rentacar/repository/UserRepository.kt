package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.UserApiService
import com.ognjen.rentacar.data.dto.response.UserResponse
import lombok.RequiredArgsConstructor


@RequiredArgsConstructor
class UserRepository {
    var userResponse: UserResponse? = null

    val apiService = RetrofitHelper.getInstance().create(UserApiService::class.java)

    val bearer =
        "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvZ2kxMjMiLCJpYXQiOjE2OTI0OTQzMjYsImV4cCI6MTY5MjQ5NDkyNn0.HH1X1mnalwc6j07Atc5RBYW4re6u9ErjR7uhlEHGMyY"

    //TODO try to use mapstruct
    suspend fun getStudentById() {
        userResponse = apiService.getProfile("Bearer $bearer")
    }
}