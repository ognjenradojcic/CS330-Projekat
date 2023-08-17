package com.ognjen.data.dto.response

data class LoginResponse (
    val accessToken: String,
    val refreshToken: String
)