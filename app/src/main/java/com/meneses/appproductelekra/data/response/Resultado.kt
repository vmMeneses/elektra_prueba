package com.meneses.appelektra.data.response

data class Resultado(
    val categoria: String,
    val paginacion: Paginacion,
    val productos: List<Producto>
)