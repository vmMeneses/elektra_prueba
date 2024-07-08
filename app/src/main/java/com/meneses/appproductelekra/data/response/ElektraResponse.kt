package com.meneses.appelektra.data.response

import com.google.gson.annotations.SerializedName

data class ElektraResponse(
    @SerializedName("advertencia")val advertencia: String,
    @SerializedName("mensaje")val mensaje: String,
    @SerializedName("resultado")val resultado: Resultado
)