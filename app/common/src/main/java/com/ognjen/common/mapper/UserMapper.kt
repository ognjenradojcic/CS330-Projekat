package com.ognjen.common.mapper

import com.ognjen.common.domain.User
import com.ognjen.data.dto.request.UserRequest
import com.ognjen.data.dto.response.UserResponse
import org.mapstruct.Mapper

@Mapper
interface UserMapper {

    fun toDomain(userResponse: UserResponse): User

    fun toRequest(user: User): UserRequest

}