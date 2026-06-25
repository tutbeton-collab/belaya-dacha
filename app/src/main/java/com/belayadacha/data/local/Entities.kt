package com.belayadacha.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

const val DATA_SCHEMA_VERSION = 1

@Entity(tableName = "participants")
data class ParticipantEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val contact: String,
    val registeredAt: Long,
    val schemaVersion: Int = DATA_SCHEMA_VERSION
)

@Entity(tableName = "draw_history")
data class DrawResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val winnerName: String,
    val winnerContact: String,
    val drawnAt: Long,
    val participantCount: Int,
    val schemaVersion: Int = DATA_SCHEMA_VERSION
)
