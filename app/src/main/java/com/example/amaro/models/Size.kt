package com.example.amaro.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Size  (
    val available: Boolean? = false,
    val size: String? = null,
    val sku: String? = null
    ): Parcelable