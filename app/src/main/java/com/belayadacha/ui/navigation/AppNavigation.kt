package com.belayadacha.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.belayadacha.ui.DrawViewModel
import com.belayadacha.ui.screens.history.HistoryScreen
import com.belayadacha.ui.screens.main.MainScreen
import com.belayadacha.ui.screens.participants.ParticipantsScreen

sealed class Screen(val route: String) {
    data object Main : Screen("main")
    data object Participants : Screen("participants")
    data object History : Screen("history")
}

@Composable
fun AppNavigation(viewModel: DrawViewModel) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(
                uiState = uiState,
                onAddParticipant = { navController.navigate(Screen.Participants.route) },
                onShowParticipants = { navController.navigate(Screen.Participants.route) },
                onDraw = { viewModel.drawWinner() },
                onShowHistory = { navController.navigate(Screen.History.route) }
            )
        }

        composable(Screen.Participants.route) {
            ParticipantsScreen(
                uiState = uiState,
                onAddParticipant = { name, contact -> viewModel.addParticipant(name, contact) },
                onDeleteParticipant = { id -> viewModel.deleteParticipant(id) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                history = uiState.history,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
