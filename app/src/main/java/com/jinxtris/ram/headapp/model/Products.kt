package com.jinxtris.ram.headapp.model

data class Products(
    var id: Int?,
    var name: String? = null,
    var date_added: String? = null,
    var variants: List<Variants>? = null,
    var tax: Tax? = null,
    var view_count: Int?,
    var order_count: Int?,
    var shares: Int?

) {
    constructor() : this(
        id = null,
        name = null,
        date_added = null,
        variants = null,
        tax = null,
        view_count = null,
        order_count = null,
        shares = null
    )
}