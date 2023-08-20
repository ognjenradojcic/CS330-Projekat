package com.ognjen.rentacar.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    var authToken = ""

    val authInterceptor = AuthInterceptor(authToken)

    fun updateToken(newToken : String){
        authInterceptor.updateToken(newToken)
    }

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(authInterceptor)
                    .build()
            ).build()
    }
}