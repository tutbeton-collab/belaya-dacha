package com.belayadacha.data.repository

import com.belayadacha.data.dao.DrawHistoryDao
import com.belayadacha.data.dao.ParticipantDao
import com.belayadacha.data.local.DrawResultEntity
import com.belayadacha.data.local.ParticipantEntity
import com.belayadacha.domain.model.DrawResult
import com.belayadacha.domain.model.Participant
import com.belayadacha.domain.repository.DrawRepository
import com.belayadacha.domain.repository.ParticipantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParticipantRepositoryImpl(
    private val dao: ParticipantDao
) : ParticipantRepository {

    override fun getAllParticipants(): Flow<List<Participant>> {
        return dao.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun addParticipant(name: String, contact: String): Participant {
        val entity = ParticipantEntity(
            name = name,
            contact = contact,
            registeredAt = System.currentTimeMillis()
        )
        val id = dao.insert(entity)
        return entity.copy(id = id).toDomain()
    }

    override suspend fun deleteParticipant(participantId: Long) {
        dao.deleteById(participantId)
    }

    override suspend fun getParticipantCount(): Int {
        return dao.getCount()
    }

    private fun ParticipantEntity.toDomain() = Participant(
        id = id,
        name = name,
        contact = contact,
        registeredAt = registeredAt
    )
}

class DrawRepositoryImpl(
    private val dao: DrawHistoryDao,
    private val participantDao: ParticipantDao
) : DrawRepository {

    override fun getHistory(): Flow<List<DrawResult>> {
        return dao.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun drawWinner(): DrawResult {
        val participantCount = participantDao.getCount()
        if (participantCount == 0) {
            throw IllegalStateException("No participants")
        }
        // Получаем всех участников для случайного выбора
        val allParticipants = mutableListOf<ParticipantEntity>()
        participantDao.getAll().collect { list ->
            allParticipants.clear()
            allParticipants.addAll(list)
        }

        val winner = allParticipants.random()
        val result = DrawResultEntity(
            winnerName = winner.name,
            winnerContact = winner.contact,
            drawnAt = System.currentTimeMillis(),
            participantCount = participantCount
        )
        val id = dao.insert(result)
        return result.copy(id = id).toDomain(winner)
    }

    override suspend fun getHistoryCount(): Int {
        return dao.getCount()
    }

    private fun DrawResultEntity.toDomain(winner: ParticipantEntity) = DrawResult(
        id = id,
        winner = Participant(
            id = winner.id,
            name = winnerName,
            contact = winnerContact,
            registeredAt = 0L
        ),
        drawnAt = drawnAt,
        participantCount = participantCount
    )

    private fun DrawResultEntity.toDomain() = DrawResult(
        id = id,
        winner = Participant(
            id = 0,
            name = winnerName,
            contact = winnerContact,
            registeredAt = 0L
        ),
        drawnAt = drawnAt,
        participantCount = participantCount
    )
}
