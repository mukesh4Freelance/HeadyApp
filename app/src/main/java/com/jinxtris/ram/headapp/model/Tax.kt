package com.jinxtris.ram.headapp.model

data class Tax (
    var name: String? = null,
    var value: Double? = 0.0

) {
    constructor() : this(
        name = null,
        value= null
    )
}