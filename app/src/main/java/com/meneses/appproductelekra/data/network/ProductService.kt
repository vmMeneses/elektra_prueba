package com.meneses.appproductelekra.data.network

import android.util.Log
import com.meneses.appelektra.data.response.ResponseGeneric
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService @Inject constructor(
    private val api: ProductClient
) {

    suspend fun getProducts(sendData: (ResponseGeneric) -> Unit) {
        withContext(Dispatchers.IO) {
            val response = api.getAllProduct()
            if (response.body() != null) {
                Log.e("Response", "Response => ${response.body()?.advertencia}")
                Log.e("Response", "Response => ${response.body()?.mensaje}")
                Log.e("Response", "Response => ${response.body()?.resultado?.categoria}")
                sendData(ResponseGeneric("Exitoso", response.body()))
            } else {
                Log.e("Response", "Response => Error")
                sendData(ResponseGeneric("Fallo el consumo", null))
            }

        }
    }

}