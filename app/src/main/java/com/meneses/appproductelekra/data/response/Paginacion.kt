package com.meneses.appelektra.data.response

data class Paginacion(
    val pagina: Int,
    val totalPaginas: Int,
    val totalRegistros: Int,
    val totalRegistrosPorPagina: Int
)