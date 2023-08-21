package com.ognjen.rentacar.repository

import android.util.Log
import com.ognjen.rentacar.data.RetrofitHelper
import com.ognjen.rentacar.data.api.InvoiceApiService
import com.ognjen.rentacar.data.dto.request.InvoiceRequest
import com.ognjen.rentacar.data.dto.response.InvoiceResponse
import com.ognjen.rentacar.data.exception.UnauthorizedException

class InvoiceRepository {
    var invoices: List<InvoiceResponse>? = null

    var invoice : InvoiceResponse? = null

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

    suspend fun create(invoiceRequest: InvoiceRequest) {
        try {
            val invoiceResponse = apiService.create(invoiceRequest)
            if (invoiceResponse.isSuccessful) {
                invoice = invoiceResponse.body()

            } else {
                val errorBody = invoiceResponse.errorBody()?.string()
                when (invoiceResponse.code()) {
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

    suspend fun delete(id: Int) {
        try {
            val deleteResponse = apiService.delete(id)
            if (deleteResponse.isSuccessful) {
                Log.i("Delete Invoice", "Neuspesno brisanje")

            } else {
                val errorBody = deleteResponse.errorBody()?.string()
                when (deleteResponse.code()) {
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