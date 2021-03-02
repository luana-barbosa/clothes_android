package com.example.amaro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.amaro.R
import com.example.amaro.models.Product
import com.example.amaro.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private lateinit var mainActivityViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel =  ViewModelProvider(this).get(MainViewModel::class.java)
        mainActivityViewModel.getProducts()
        mainActivityViewModel.observeProducts(this) { handleProducts(it) }
    }

    private fun handleProducts(products: List<Product>){
        rv_products?.layoutManager = GridLayoutManager(context,2)
        rv_products?.adapter = ProductAdapter(products)

    }
}