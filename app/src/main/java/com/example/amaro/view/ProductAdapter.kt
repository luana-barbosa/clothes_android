package com.example.amaro.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amaro.R
import com.example.amaro.models.Product
import com.google.android.material.circularreveal.CircularRevealGridLayout
import com.squareup.picasso.Picasso


class ProductAdapter(var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        val holder = ViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (products[position].image.isNotEmpty())
            Picasso.get().load(products[position].image).into(holder.productImage)
        holder.productName.text = products[position].name
        holder.productView.setOnClickListener {
            val intent = Intent(holder.productView.context, DetailsActivity::class.java)
            intent.putExtra("extra_product", products[position])
            holder.productView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productView: CircularRevealGridLayout = itemView.findViewById(R.id.productView)
    }
}
