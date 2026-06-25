package com.belayadacha.domain.usecase

import com.belayadacha.domain.model.DrawResult
import com.belayadacha.domain.model.Participant
import com.belayadacha.domain.repository.DrawRepository
import com.belayadacha.domain.repository.ParticipantRepository

class AddParticipantUseCase(
    private val participantRepository: ParticipantRepository
) {
    suspend operator fun invoke(name: String, contact: String): Result<Participant> {
        if (name.isBlank()) {
            return Result.failure(ValidationException("Имя не может быть пустым"))
        }
        if (contact.isBlank()) {
            return Result.failure(ValidationException("Контакт не может быть пустым"))
        }
        val participant = participantRepository.addParticipant(name.trim(), contact.trim())
        return Result.success(participant)
    }
}

class DeleteParticipantUseCase(
    private val participantRepository: ParticipantRepository
) {
    suspend operator fun invoke(participantId: Long) {
        participantRepository.deleteParticipant(participantId)
    }
}

class GetParticipantsUseCase(
    private val participantRepository: ParticipantRepository
) {
    operator fun invoke() = participantRepository.getAllParticipants()
}

class DrawWinnerUseCase(
    private val drawRepository: DrawRepository,
    private val participantRepository: ParticipantRepository
) {
    suspend operator fun invoke(): Result<DrawResult> {
        val count = participantRepository.getParticipantCount()
        if (count == 0) {
            return Result.failure(NoParticipantsException("Нет участников для розыгрыша"))
        }
        val result = drawRepository.drawWinner()
        return Result.success(result)
    }
}

class GetHistoryUseCase(
    private val drawRepository: DrawRepository
) {
    operator fun invoke() = drawRepository.getHistory()
}

class GetParticipantCountUseCase(
    private val participantRepository: ParticipantRepository
) {
    suspend operator fun invoke() = participantRepository.getParticipantCount()
}

class GetHistoryCountUseCase(
    private val drawRepository: DrawRepository
) {
    suspend operator fun invoke() = drawRepository.getHistoryCount()
}

class ValidationException(message: String) : Exception(message)
class NoParticipantsException(message: String) : Exception(message)
