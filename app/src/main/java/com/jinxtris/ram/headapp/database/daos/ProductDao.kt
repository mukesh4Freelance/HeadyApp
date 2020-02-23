package com.jinxtris.ram.headapp.database.daos

import androidx.room.*
import com.jinxtris.ram.headapp.database.entities.ProductList

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllProductList(): MutableList<ProductList>

    @Query("SELECT * FROM product where prod_id == :id")
    fun getSelectedProductList(id: Int): MutableList<ProductList>

    @Query("DELETE FROM product")
    fun deleteAll()

    @Update
    fun updateRecord(categoryData: ProductList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryData: ProductList)
}