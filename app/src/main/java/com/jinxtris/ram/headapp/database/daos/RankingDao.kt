package com.jinxtris.ram.headapp.database.daos

import androidx.room.*
import com.jinxtris.ram.headapp.database.entities.RankingList

@Dao
interface RankingDao {
    @Query("SELECT * FROM rankings")
    fun getRankingList(): MutableList<RankingList>

    @Query("DELETE FROM rankings")
    fun deleteAll()

    @Update
    fun updateRecord(rankingData: RankingList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(rankingData: RankingList)
}