package com.belayadacha.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.belayadacha.data.local.DrawResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrawHistoryDao {
    @Query("SELECT * FROM draw_history ORDER BY drawnAt DESC")
    fun getAll(): Flow<List<DrawResultEntity>>

    @Insert
    suspend fun insert(entity: DrawResultEntity): Long

    @Query("SELECT COUNT(*) FROM draw_history")
    suspend fun getCount(): Int

    @Query("DELETE FROM draw_history")
    suspend fun clearAll()
}
