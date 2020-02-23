package com.jinxtris.ram.headapp.database.daos

import androidx.room.*
import com.jinxtris.ram.headapp.database.entities.CategoryList

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getCategoryList(): MutableList<CategoryList>

    @Query("DELETE FROM category")
    fun deleteAll()

    @Update
    fun updateRecord(categoryData: CategoryList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryData: CategoryList)
}