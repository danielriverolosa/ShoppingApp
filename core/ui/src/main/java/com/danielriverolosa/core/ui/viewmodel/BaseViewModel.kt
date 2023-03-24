package com.danielriverolosa.core.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielriverolosa.core.domain.dispatcher.DefaultDispatcherProvider
import com.danielriverolosa.core.domain.dispatcher.DispatcherProvider
import com.danielriverolosa.core.ui.action.UiAction
import com.danielriverolosa.core.ui.error.ErrorMessage
import com.danielriverolosa.core.ui.state.UiContentState
import com.danielriverolosa.core.ui.state.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiContentState, Action : UiAction>(
    initialState: UiState<State> = UiState.Loading,
    private val dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider()
) : ViewModel() {

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

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(dispatcherProvider.main) {
            block()
        }
    }

    fun mapToErrorState(throwable: Throwable): UiState.Error {
        Log.e("ERROR", throwable.stackTraceToString())
        return UiState.Error(
            ErrorMessage(
                throwable.localizedMessage.orEmpty(),
                throwable.message.orEmpty()
            )
        )
    }

}