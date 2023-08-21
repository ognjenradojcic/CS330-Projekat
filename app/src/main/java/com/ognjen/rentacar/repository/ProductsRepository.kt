package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.ProductApiService
import com.ognjen.rentacar.data.dto.response.ProductResponse
import com.ognjen.rentacar.data.exception.UnauthorizedException

class ProductsRepository {
    var products: List<ProductResponse>? = null

    var apiService = RetrofitHelper.getInstance().create(ProductApiService::class.java)

    suspend fun getAll() {
        try {
            val response = apiService.getAll()
            if (response.isSuccessful) {
                products = response.body()

            } else {
                val errorBody = response.errorBody()?.string()
                when (response.code()) {
                    400 -> {
                        println("Neuspesno")
                    }

                    401 -> {
                        throw UnauthorizedException("Unauthorized")
                    }

                    404 -> {
                        println("Neuspesno")
                    }
                    // Handle other error codes
                    else -> {
                        println("Neuspesno")
                    }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }

    }

}