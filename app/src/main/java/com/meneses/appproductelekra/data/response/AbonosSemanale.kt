package com.meneses.appelektra.data.response

data class AbonosSemanale(
    val idPromocion: Int,
    val montoAbono: Int,
    val montoAbonoDigital: Int,
    val montoDescuentoAbono: Int,
    val montoDescuentoBanco: Int,
    val montoDescuentoElektra: Int,
    val montoFinalCredito: Int,
    val montoUltimoAbono: Int,
    val plazo: Int,
    val precio: Int
)