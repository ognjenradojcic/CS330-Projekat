package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.UserApiService
import com.ognjen.rentacar.data.dto.response.UserResponse
import lombok.RequiredArgsConstructor


@RequiredArgsConstructor
class UserRepository {

    //TODO try to use mapstruct
    suspend fun getStudentById(): UserResponse {
        val apiService = RetrofitHelper.getInstance().create(UserApiService::class.java)
        return apiService.getById(1)
    }
}