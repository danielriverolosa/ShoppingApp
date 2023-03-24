package com.danielriverolosa.core.ui.state

import com.danielriverolosa.core.ui.error.ErrorMessage

sealed interface UiState<out T> {
    class Content<out T: UiContentState>(val content: T) : UiState<T>
    class Error(val message: ErrorMessage) : UiState<Nothing>
    object Loading : UiState<Nothing>
}