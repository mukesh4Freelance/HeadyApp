package com.jinxtris.ram.headapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")

data class ProductList(
    @PrimaryKey @ColumnInfo(name = "prod_id") var id: Int?,
    @ColumnInfo(name = "product_name") var name: String?,
    @ColumnInfo(name = "added_date") var prodDate: String?,
    @Embedded
    var variants: List<Variants>?,
    @ColumnInfo(name = "tax_name") var taxName: String?,
    @ColumnInfo(name = "tax_value") var taxValue: Double?,
    @ColumnInfo(name = "view_count") var viewCount: Int?,
    @ColumnInfo(name = "order_count") var orderCount: Int?,
    @ColumnInfo(name = "shares") var shares: Int?
) {
    constructor() : this(
        id = null,
        name = null,
        prodDate = null,
        variants = emptyList(),
        taxName = null,
        taxValue = null,
        viewCount = null,
        orderCount = null,
        shares = null
    )
}