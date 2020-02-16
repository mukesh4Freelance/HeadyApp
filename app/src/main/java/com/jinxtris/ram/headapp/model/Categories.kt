package com.jinxtris.ram.headapp.model

data class Categories(
    var id: Int?,
    var name: String? = null,
    var products: List<Products>? = null,
    var child_categories: List<String>? = null

) {
    constructor() : this(
        id = null,
        name = null,
        products = null,
        child_categories = null
    )
}
