package com.ognjen.rentacar.repository

import android.util.Log
import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.UserApiService
import com.ognjen.rentacar.data.dto.request.UserRequest
import com.ognjen.rentacar.data.dto.response.UserResponse
import lombok.RequiredArgsConstructor


@RequiredArgsConstructor
class UserRepository {
    var userResponse: UserResponse? = null

    var apiService = RetrofitHelper.getInstance().create(UserApiService::class.java)

    suspend fun getById() {
        try{
            val response = apiService.getProfile()
            if(response.isSuccessful){
                userResponse = response.body()
            } else{
                val errorBody = response.errorBody()?.string()
                when (response.code()){
                    400 -> {
                        println("Greska")
                    }
                    401 -> {
                        println("Ne moze")
                    }
                    404 -> {
                        println("Nema")
                    }
                    // Handle other error codes
                    else -> {
                        println("Neuspesno")
                    }
                }
            }
        } catch (e: Exception){
            println(e.message)
        }
    }

    suspend fun updateUser(id: Int, userRequest: UserRequest ){
        val response = apiService.update(id, userRequest)

        if(response.isSuccessful){
            Log.i("Response User", "Uspesno ste update")
        } else{
            when (response.code()){
                400 -> {
                    println("Greska")
                }
                401 -> {
                    println("Nije Vam dozvoljeno")
                }
                404 -> {
                    println("Nema")
                }
                // Handle other error codes
                else -> {
                    println("Neuspesno")
                }
            }

        }

    }
}