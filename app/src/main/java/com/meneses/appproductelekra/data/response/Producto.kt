package com.meneses.appelektra.data.response

data class Producto(
    val abonosSemanales: List<AbonosSemanale>,
    val codigoCategoria: String,
    val descuento: Boolean,
    val disponibleCredito: Boolean,
    val id: String,
    val idLinea: Int,
    val idModalidad: Int,
    val lineaCredito: String,
    val montoDescuento: Double,
    val nombre: String,
    val pagoSemanalPrincipal: Int,
    val plazoPrincipal: Int,
    val porcentajeDescuento: Double,
    val precioCredito: Double,
    val precioFinal: Double,
    val precioRegular: Int,
    val relevancia: Int,
    val sku: String,
    val urlImagenes: List<String>
)