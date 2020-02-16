package com.jinxtris.ram.headapp.model

data class Products(
    var id: Int?,
    var name: String? = null,
    var date_added: String? = null,
    var variants: List<Variants>? = null,
    var tax: Tax? = null

) {
    constructor() : this(
        id = null,
        name = null,
        date_added = null,
        variants = null,
        tax = null
    )
}