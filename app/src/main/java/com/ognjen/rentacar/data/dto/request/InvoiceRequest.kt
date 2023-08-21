package com.ognjen.rentacar.data.dto.request

data class InvoiceRequest(
    val address : String,
    val userId : Int,
    val items : List<InvoiceItemRequest>
) {
    data class InvoiceItemRequest(
        val productId : Int,
        val quantity : Int
    )
}