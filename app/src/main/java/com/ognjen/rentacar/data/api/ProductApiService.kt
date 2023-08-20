package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.response.ProductResponse
import retrofit2.http.GET

interface ProductApiService {
    @GET(Constants.PRODUCTS_URL)
    suspend fun getAll() : List<ProductResponse>

}