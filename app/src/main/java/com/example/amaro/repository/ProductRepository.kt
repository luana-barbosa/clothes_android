package com.example.amaro.repository

import com.example.amaro.models.Product
import com.example.amaro.models.Size
import com.example.amaro.retrofit.APIService.retrofit
import com.example.amaro.retrofit.ProductsService

class ProductRepository {

     fun getProducts() : List<Product>{
        val productsService = retrofit?.create(ProductsService::class.java)
        val result =  productsService?.getProducts()?.execute()
        val productList : ArrayList<Product> = arrayListOf()
        if(result!= null && result.isSuccessful) {
            result.body()?.products?.forEach { productResponse ->
                val product = Product()
                product.name = productResponse.name ?: ""
                product.image = productResponse.image ?:""
                product.regular_price = productResponse.regular_price ?:""
                product.actual_price = productResponse.actual_price ?:""
                product.on_sale = productResponse.on_sale ;
                product.discount_percentage = productResponse.discount_percentage ?:""
                product.installments = productResponse.installments ?:""
                product.sizes = arrayListOf()
                productResponse.sizes?.forEach {
                    product.sizes?.add(Size(it.available, it.size, it.sku))
                }
                productList.add(product)
            }
        }
        return productList
     }
}