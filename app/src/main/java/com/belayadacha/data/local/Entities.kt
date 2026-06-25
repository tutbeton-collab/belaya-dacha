package com.belayadacha.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "participants")
data class ParticipantEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val contact: String,
    val registeredAt: Long
)

@Entity(tableName = "draw_history")
data class DrawResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val winnerName: String,
    val winnerContact: String,
    val drawnAt: Long,
    val participantCount: Int
)
