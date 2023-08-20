package com.ognjen.rentacar.data

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private var authToken: String) : Interceptor {

    fun updateToken(newToken: String){
        authToken = newToken
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $authToken")
            .build()

        return chain.proceed(modifiedRequest)
    }
}