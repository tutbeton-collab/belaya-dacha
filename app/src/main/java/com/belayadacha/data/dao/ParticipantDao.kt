package com.belayadacha.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.belayadacha.data.local.ParticipantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ParticipantDao {
    @Query("SELECT * FROM participants ORDER BY registeredAt DESC")
    fun getAll(): Flow<List<ParticipantEntity>>

    @Query("SELECT * FROM participants ORDER BY registeredAt DESC")
    suspend fun getAllOnce(): List<ParticipantEntity>

    @Insert
    suspend fun insert(entity: ParticipantEntity): Long

    @Query("DELETE FROM participants WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT COUNT(*) FROM participants")
    suspend fun getCount(): Int
}
