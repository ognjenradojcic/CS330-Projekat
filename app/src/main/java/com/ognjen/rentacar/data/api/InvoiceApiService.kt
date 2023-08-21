package com.ognjen.rentacar.data.api

import com.ognjen.rentacar.data.Constants
import com.ognjen.rentacar.data.dto.request.InvoiceRequest
import com.ognjen.rentacar.data.dto.response.InvoiceResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InvoiceApiService {
    @GET(Constants.INVOICES_URL)
    suspend fun getAll() : Response<List<InvoiceResponse>>

    @POST(Constants.INVOICES_URL)
    suspend fun create(@Body invoiceRequest: InvoiceRequest) : Response<InvoiceResponse>

    @DELETE(Constants.INVOICES_URL + "/{id}")
    suspend fun delete(@Path("id") id : Int) : Response<Unit>
}