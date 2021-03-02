package com.example.amaro.retrofit

import com.example.amaro.response.ProductListResponse
import retrofit2.Call
import retrofit2.http.GET


interface ProductsService {
        @GET("v2/59b6a65a0f0000e90471257d")
        fun getProducts() : Call<ProductListResponse>
}