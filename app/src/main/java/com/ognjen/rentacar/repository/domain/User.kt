package com.ognjen.rentacar.repository.domain

data class User(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val phone: String
)