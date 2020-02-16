package com.jinxtris.ram.headapp.model

data class Rankings (
    var ranking: String? = null,
    var products: List<Products>? = null

) {
    constructor() :this(
        ranking = null,
        products = null
    )
}