package com.meneses.appproductelekra.ui.productlist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meneses.appelektra.data.response.Producto
import com.meneses.appproductelekra.domain.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
):ViewModel(){

    val isLoading = MutableLiveData<Boolean>()
    val listProduct = MutableLiveData<List<Producto>>(listOf())
    val msg = MutableLiveData<String>()


    fun getProducts() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = getProductsUseCase()
            Log.e("ResponseViewMOdel","R = $response")
            listProduct.value = response.data?.resultado?.productos
            msg.value = response.msg
            isLoading.postValue(false)
        }
    }
}