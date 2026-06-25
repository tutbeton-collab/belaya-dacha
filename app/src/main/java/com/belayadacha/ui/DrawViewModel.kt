package com.belayadacha.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.belayadacha.domain.model.DrawResult
import com.belayadacha.domain.model.DrawUiState
import com.belayadacha.domain.model.Participant
import com.belayadacha.domain.usecase.AddParticipantUseCase
import com.belayadacha.domain.usecase.DeleteParticipantUseCase
import com.belayadacha.domain.usecase.DrawWinnerUseCase
import com.belayadacha.domain.usecase.GetHistoryCountUseCase
import com.belayadacha.domain.usecase.GetHistoryUseCase
import com.belayadacha.domain.usecase.GetParticipantCountUseCase
import com.belayadacha.domain.usecase.GetParticipantsUseCase
import com.belayadacha.domain.usecase.ClearHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DrawViewModel(
    private val addParticipantUseCase: AddParticipantUseCase,
    private val deleteParticipantUseCase: DeleteParticipantUseCase,
    private val getParticipantsUseCase: GetParticipantsUseCase,
    private val drawWinnerUseCase: DrawWinnerUseCase,
    private val getHistoryUseCase: GetHistoryUseCase,
    private val getParticipantCountUseCase: GetParticipantCountUseCase,
    private val getHistoryCountUseCase: GetHistoryCountUseCase,
    private val clearHistoryUseCase: ClearHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DrawUiState())
    val uiState: StateFlow<DrawUiState> = _uiState.asStateFlow()

    init {
        observeParticipants()
        observeHistory()
    }

    private fun observeParticipants() {
        viewModelScope.launch {
            getParticipantsUseCase().collect { participants ->
                _uiState.update { it.copy(participants = participants) }
                updateCounts()
            }
        }
    }

    private fun observeHistory() {
        viewModelScope.launch {
            getHistoryUseCase().collect { history ->
                _uiState.update { it.copy(history = history) }
                updateCounts()
            }
        }
    }

    private suspend fun updateCounts() {
        val participantCount = getParticipantCountUseCase()
        val historyCount = getHistoryCountUseCase()
        _uiState.update { it.copy(participantCount = participantCount, historyCount = historyCount) }
    }

    fun addParticipant(name: String, contact: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(errorMessage = null) }
            val result = addParticipantUseCase(name, contact)
            result.fold(
                onSuccess = { participant ->
                    _uiState.update {
                        it.copy(
                            isDrawing = false,
                            currentWinner = null,
                            errorMessage = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(errorMessage = error.message ?: "Ошибка добавления")
                    }
                }
            )
        }
    }

    fun deleteParticipant(participantId: Long) {
        viewModelScope.launch {
            deleteParticipantUseCase(participantId)
        }
    }

    fun drawWinner() {
        viewModelScope.launch {
            _uiState.update { it.copy(isDrawing = true, errorMessage = null, currentWinner = null) }
            val result = drawWinnerUseCase()
            result.fold(
                onSuccess = { drawResult ->
                    _uiState.update {
                        it.copy(
                            isDrawing = false,
                            currentWinner = drawResult.winner,
                            errorMessage = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(
                            isDrawing = false,
                            errorMessage = error.message ?: "Ошибка розыгрыша"
                        )
                    }
                }
            )
        }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    fun clearHistory() {
        viewModelScope.launch {
            clearHistoryUseCase()
            _uiState.update { it.copy(currentWinner = null) }
        }
    }

    class Factory(
        private val addParticipantUseCase: AddParticipantUseCase,
        private val deleteParticipantUseCase: DeleteParticipantUseCase,
        private val getParticipantsUseCase: GetParticipantsUseCase,
        private val drawWinnerUseCase: DrawWinnerUseCase,
        private val getHistoryUseCase: GetHistoryUseCase,
        private val getParticipantCountUseCase: GetParticipantCountUseCase,
        private val getHistoryCountUseCase: GetHistoryCountUseCase,
        private val clearHistoryUseCase: ClearHistoryUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DrawViewModel(
                addParticipantUseCase,
                deleteParticipantUseCase,
                getParticipantsUseCase,
                drawWinnerUseCase,
                getHistoryUseCase,
                getParticipantCountUseCase,
                getHistoryCountUseCase,
                clearHistoryUseCase
            ) as T
        }
    }
}
