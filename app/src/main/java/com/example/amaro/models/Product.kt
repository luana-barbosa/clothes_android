package com.example.amaro.models

import android.os.Parcel
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

@Parcelize
 open class Product(
    var name: String = "",

    var image: String = "",

    var regular_price: String = "",

    var actual_price: String = "",

    var on_sale: Boolean = false,

    var discount_percentage: String = "",

    var installments: String = "",

    var sizes: ArrayList<Size>? = null
    ) : Parcelable