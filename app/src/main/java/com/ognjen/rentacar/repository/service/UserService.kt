package com.ognjen.rentacar.repository.service

import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.repository.UserRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@OptIn(DelicateCoroutinesApi::class)
class UserService {

    var repository = UserRepository();
    private val _user = MutableStateFlow<UserResponse?>(null)
    val user: StateFlow<UserResponse?> = _user

}