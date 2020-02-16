package com.jinxtris.ram.headapp.model

data class Root(
    var categories: List<Categories>? = null,
    var rankings: List<Rankings>? = null
) {
    constructor() : this(
        categories = null,
        rankings = null
    )
}
