package com.danielriverolosa.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.danielriverolosa.core.ui.action.UiAction
import com.danielriverolosa.core.ui.state.UiContentState
import com.danielriverolosa.core.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<State: UiContentState, Action: UiAction>(
    initialState: UiState<State> = UiState.Loading
): ViewModel() {

    private val mutableState = MutableStateFlow(initialState)

    val state: StateFlow<UiState<State>>
        get() = mutableState

    protected fun UiState<State>.emit() {
        mutableState.value = this
    }

    protected fun State.emit() {
        UiState.Content(this).emit()
    }

    abstract fun handleAction(action: Action)

}