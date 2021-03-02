package com.example.amaro.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amaro.models.Product
import com.example.amaro.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var productRepository : ProductRepository = ProductRepository()

    private val productList: MutableLiveData<List<Product>> = MutableLiveData()

     fun getProducts(){
         viewModelScope.launch (Dispatchers.IO) {
             productList.postValue(productRepository.getProducts())
         }
    }

    fun observeProducts(
        lifecycleOwner: LifecycleOwner,
        action: (List<Product>) -> Unit
    ) = productList.observe(lifecycleOwner, { action(it) })
}