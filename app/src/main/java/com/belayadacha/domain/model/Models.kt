package com.belayadacha.domain.model

data class Participant(
    val id: Long = 0,
    val name: String,
    val contact: String,
    val registeredAt: Long = System.currentTimeMillis()
)

data class DrawResult(
    val id: Long = 0,
    val winner: Participant,
    val drawnAt: Long = System.currentTimeMillis(),
    val participantCount: Int
)

data class DrawUiState(
    val participants: List<Participant> = emptyList(),
    val history: List<DrawResult> = emptyList(),
    val isDrawing: Boolean = false,
    val currentWinner: Participant? = null,
    val errorMessage: String? = null,
    val participantCount: Int = 0,
    val historyCount: Int = 0
)
