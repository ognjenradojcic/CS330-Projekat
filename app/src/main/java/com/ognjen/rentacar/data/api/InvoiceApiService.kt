package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.response.InvoiceResponse
import retrofit2.Response
import retrofit2.http.GET

interface InvoiceApiService {
    @GET(Constants.INVOICES_URL)
    suspend fun getAll() : Response<List<InvoiceResponse>>

}