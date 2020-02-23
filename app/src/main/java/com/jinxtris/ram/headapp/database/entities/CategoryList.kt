package com.jinxtris.ram.headapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryList(
    @PrimaryKey var id: Int?,
    @ColumnInfo(name = "name") var name: String?,
    //@ColumnInfo(name = "prod_id") var prodid: String?,
    @Embedded
    var product: List<ProductList>,
    @ColumnInfo(name = "child_list") var childlist: List<String>?
) {
    constructor() : this(
        id = null,
        name = null,
        product = emptyList(),
        childlist = null
    )
}