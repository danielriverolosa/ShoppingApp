package com.danielriverolosa.core.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.danielriverolosa.core.ui.composable.GenericErrorScreen
import com.danielriverolosa.core.ui.composable.GenericLoadingScreen
import com.danielriverolosa.core.ui.error.ErrorMessage
import kotlinx.coroutines.flow.StateFlow

@Composable
inline fun <reified ContentState : UiContentState> StateFlow<UiState<ContentState>>.handleUiState(
    ContentScreen: @Composable (ContentUiState: ContentState) -> Unit,
    ErrorScreen: @Composable (ErrorMessage) -> Unit = { GenericErrorScreen(it) },
    LoadingScreen: @Composable () -> Unit = { GenericLoadingScreen() }
) {
    when (val stateValue = this.collectAsState().value) {
        is UiState.Content -> ContentScreen(stateValue.content)
        is UiState.Error -> ErrorScreen(stateValue.message)
        is UiState.Loading -> LoadingScreen()
    }
}