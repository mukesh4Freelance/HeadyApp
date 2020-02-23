package com.jinxtris.ram.headapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "variant")

data class Variants(
    @PrimaryKey var id: Int?,
    var colour: String?,
    var size: Int?,
    var price: Int?
) {
    constructor() : this(
        id = null,
        colour = null,
        size = null,
        price = null
    )
}