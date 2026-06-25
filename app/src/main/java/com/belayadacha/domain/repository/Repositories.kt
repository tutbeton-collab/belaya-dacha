package com.belayadacha.domain.repository

import com.belayadacha.domain.model.DrawResult
import com.belayadacha.domain.model.Participant
import kotlinx.coroutines.flow.Flow

interface ParticipantRepository {
    fun getAllParticipants(): Flow<List<Participant>>
    suspend fun addParticipant(name: String, contact: String): Participant
    suspend fun deleteParticipant(participantId: Long)
    suspend fun getParticipantCount(): Int
}

interface DrawRepository {
    fun getHistory(): Flow<List<DrawResult>>
    suspend fun drawWinner(): DrawResult
    suspend fun getHistoryCount(): Int
    suspend fun clearHistory()
}
