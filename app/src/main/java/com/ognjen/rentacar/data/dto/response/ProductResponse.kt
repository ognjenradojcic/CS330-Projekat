package com.ognjen.rentacar.data.dto.response

data class ProductResponse(
    val id: Int,
    val name: String,
    val manufacturer: String,
    val price: Double,
    val category: ProductCategoryResponse
) {
    data class ProductCategoryResponse(
        val id: Int,
        val name: String
    )
}
