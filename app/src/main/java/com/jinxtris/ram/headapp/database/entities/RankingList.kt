package com.jinxtris.ram.headapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rankings")

data class RankingList(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "ranking_name") var rankingType: String?,
    @Embedded
    var product: List<ProductList>
) {
    constructor() : this(
        id = null,
        rankingType = null,
        product = emptyList()
    )
}