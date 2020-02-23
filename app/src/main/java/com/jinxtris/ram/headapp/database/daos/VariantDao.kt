package com.jinxtris.ram.headapp.database.daos

import androidx.room.*
import com.jinxtris.ram.headapp.database.entities.Variants

@Dao
interface VariantDao {
    @Query("SELECT * FROM variant")
    fun getVariantList(): MutableList<Variants>

    @Query("DELETE FROM variant")
    fun deleteAll()

    @Update
    fun updateRecord(rankingData: Variants)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(rankingData: Variants)
}