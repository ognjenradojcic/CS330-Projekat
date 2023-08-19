package com.ognjen.rentacar.data.dto.response

data class LoginResponse (
    val accessToken: String,
    val refreshToken: String
)