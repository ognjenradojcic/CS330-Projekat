package com.ognjen.rentacar.repository.mapper

import com.ognjen.rentacar.data.dto.request.UserRequest
import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.repository.domain.User
import org.mapstruct.Mapper

@Mapper
interface UserMapper {

    fun toDomain(userResponse: UserResponse): User

    fun toRequest(user: User): UserRequest

}