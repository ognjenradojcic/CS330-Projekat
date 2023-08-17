package com.ognjen.data.dto.request

data class RegisterRequest(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val phone: String
)