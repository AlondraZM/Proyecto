package com.example.proyecto


import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyecto.database.DatabaseManager
import com.example.proyecto.database.MyCoroutines2
import com.example.proyecto.database.Product
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveProduct(product: Product){
        viewModelScope.launch {
            val productDao = DatabaseManager.instance.database.productDao()
            MyCoroutines2(productDao).save(product)
        }
    }
    fun deleteProduct(product: Product){
        viewModelScope.launch {
            val productDao = DatabaseManager.instance.database.productDao()
            MyCoroutines2(productDao).delete(product)
        }
    }

    val savedProducts = MutableLiveData<List<Product>>()
    fun getProducts(){
        viewModelScope.launch {
            val productDao = DatabaseManager.instance.database.productDao()
            savedProducts.value = MyCoroutines2(productDao).getProducts().value
        }
    }
}