package com.ognjen.rentacar.data.dto.response

data class InvoiceResponse(
    val id : Int,
    val address : String,
    val orderedDate : String,
    val userId : Int,
    val items : List<InvoiceItemResponse>
) {
    data class InvoiceItemResponse(
        val id : Int,
        val product : ProductResponse,
        val quantity : Int
    )
}