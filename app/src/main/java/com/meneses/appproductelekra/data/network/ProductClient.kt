package com.meneses.appproductelekra.data.network

import com.meneses.appelektra.data.response.ElektraResponse
import retrofit2.Response
import retrofit2.http.GET


interface ProductClient {
    @GET("/apps/moviles/caso-practico/plp")
    suspend fun getAllProduct(): Response<ElektraResponse>
}