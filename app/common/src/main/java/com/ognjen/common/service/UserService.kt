package com.ognjen.common.service

import com.ognjen.common.domain.User
import com.ognjen.repository.UserRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class UserService {

    var repository = UserRepository();
    lateinit var user: User

    fun getById() {
        GlobalScope.launch {
            user = repository.getStudentById()
        }

    }

}