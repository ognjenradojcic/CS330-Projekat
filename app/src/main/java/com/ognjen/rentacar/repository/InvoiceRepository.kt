package com.ognjen.rentacar.repository

import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.InvoiceApiService
import com.ognjen.rentacar.data.dto.response.InvoiceResponse

class InvoiceRepository {
    var invoices: List<InvoiceResponse>? = null

    var apiService = RetrofitHelper.getInstance().create(InvoiceApiService::class.java)

    suspend fun getAll() {
        try {
            val response = apiService.getAll()
            if (response.isSuccessful) {
                invoices = response.body()

            } else {
                val errorBody = response.errorBody()?.string()
                when (response.code()) {
                    400 -> {
                        println("Neuspesno")
                    }

                    401 -> {
                        println("Neuspesno")
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