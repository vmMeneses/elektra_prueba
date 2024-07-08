package com.meneses.appproductelekra.domain

import android.util.Log
import com.meneses.appelektra.data.response.ResponseGeneric
import com.meneses.appproductelekra.data.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductRepository
) {

    suspend operator fun invoke(): ResponseGeneric {
        var response = ResponseGeneric("",null)
        productsRepository.getProducts(){
            Log.e("ResponseRepository"," => ${it.data?.resultado?.productos}")
            response = it
        }
        return response
    }


}