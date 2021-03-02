package com.example.amaro.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
        var retrofit : Retrofit? = null
        get(){
                return if(field == null) {
                                Retrofit.Builder()
                                        .baseUrl("http://www.mocky.io/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
                        } else {
                               field
                       }
                }
}