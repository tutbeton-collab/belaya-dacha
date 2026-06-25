package com.belayadacha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.belayadacha.data.database.AppDatabase
import com.belayadacha.data.repository.DrawRepositoryImpl
import com.belayadacha.data.repository.ParticipantRepositoryImpl
import com.belayadacha.domain.usecase.AddParticipantUseCase
import com.belayadacha.domain.usecase.DeleteParticipantUseCase
import com.belayadacha.domain.usecase.DrawWinnerUseCase
import com.belayadacha.domain.usecase.GetHistoryCountUseCase
import com.belayadacha.domain.usecase.GetHistoryUseCase
import com.belayadacha.domain.usecase.GetParticipantCountUseCase
import com.belayadacha.domain.usecase.GetParticipantsUseCase
import com.belayadacha.domain.usecase.ClearHistoryUseCase
import com.belayadacha.ui.DrawViewModel
import com.belayadacha.ui.navigation.AppNavigation
import com.belayadacha.ui.theme.BelayaDachaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getInstance(applicationContext)
        val participantDao = database.participantDao()
        val drawHistoryDao = database.drawHistoryDao()

        val participantRepository = ParticipantRepositoryImpl(participantDao)
        val drawRepository = DrawRepositoryImpl(drawHistoryDao, participantDao)

        val addParticipantUseCase = AddParticipantUseCase(participantRepository)
        val deleteParticipantUseCase = DeleteParticipantUseCase(participantRepository)
        val getParticipantsUseCase = GetParticipantsUseCase(participantRepository)
        val drawWinnerUseCase = DrawWinnerUseCase(drawRepository, participantRepository)
        val getHistoryUseCase = GetHistoryUseCase(drawRepository)
        val getParticipantCountUseCase = GetParticipantCountUseCase(participantRepository)
        val getHistoryCountUseCase = GetHistoryCountUseCase(drawRepository)
        val clearHistoryUseCase = ClearHistoryUseCase(drawRepository)

        val viewModel = ViewModelProvider(
            this,
            DrawViewModel.Factory(
                addParticipantUseCase,
                deleteParticipantUseCase,
                getParticipantsUseCase,
                drawWinnerUseCase,
                getHistoryUseCase,
                getParticipantCountUseCase,
                getHistoryCountUseCase,
                clearHistoryUseCase
            )
        )[DrawViewModel::class.java]

        setContent {
            BelayaDachaTheme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}
