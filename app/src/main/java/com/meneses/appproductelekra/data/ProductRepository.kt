package com.meneses.appproductelekra.data

import android.util.Log
import com.meneses.appelektra.data.response.ResponseGeneric
import com.meneses.appproductelekra.data.network.ProductService
import javax.inject.Inject

class ProductRepository  @Inject constructor(
    private val service: ProductService
) {

    suspend fun getProducts(responseService: (ResponseGeneric)->Unit){
        service.getProducts(){ response ->
            Log.e("DataRepository","Data ${response.data?.resultado?.productos}")
            responseService(response)
        }
    }
}