package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.ProductApiService
import com.ognjen.rentacar.data.dto.response.ProductResponse

class ProductsRepository {
    var products: List<ProductResponse>? = null

    val apiService = RetrofitHelper.getInstance().create(ProductApiService::class.java)


    //TODO try to use mapstruct
    suspend fun getAll() {
        products = apiService.getAll()
    }


}