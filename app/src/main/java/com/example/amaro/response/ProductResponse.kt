package com.example.amaro.response


data class ProductListResponse(
    var products: ArrayList<Product>? = null
)

data class Product(
    val name: String? = "",
    val style: String? = "",

    val code_color: String? = "",

    val color_slug: String? = "",

    val color: String? = "",

    val on_sale: Boolean = false,

    val regular_price: String? = "",

    val actual_price: String? = "",

    val discount_percentage: String? = "",
    val installments: String? = "",
    val image: String? = "",
    val sizes: ArrayList<Size> ? = null
)

data class Size(
    val available: Boolean? = false,
    val size: String? = null,
    val sku: String? = null
)



