package com.ognjen.repository

import com.ognjen.common.domain.User
import com.ognjen.common.mapper.UserMapper
import com.ognjen.data.RetrofitHelper
import com.ognjen.data.service.UserApiService
import lombok.RequiredArgsConstructor
import org.mapstruct.factory.Mappers


@RequiredArgsConstructor
class UserRepository {

    val mapper = Mappers.getMapper(UserMapper::class.java)
    suspend fun getStudentById(): User {
        val apiService = RetrofitHelper.getInstance().create(UserApiService::class.java)
        return mapper.toDomain(apiService.getById(1))
    }
}