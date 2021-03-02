package com.example.amaro.view

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.amaro.R
import com.example.amaro.models.Product
import com.example.amaro.models.Size
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.app_bar.*

class DetailsActivity : AppCompatActivity() {

    lateinit var product : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

       product = intent.getParcelableExtra<Product>("extra_product") as Product
        productName.text = product.name
        Picasso.get().load(product.image).into(productImage)
        regular_price.text = product.regular_price
        actual_price.text = product.actual_price
        installments.text = product.installments
    }
}