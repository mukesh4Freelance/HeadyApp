package com.jinxtris.ram.headapp.model

data class Variants(
    var id: Int?,
    var color: String? = null,
    var size: Int?,
    var price: Int?

) {
    constructor() : this(
        id = null,
        color = null,
        size = null,
        price = null
    )
}