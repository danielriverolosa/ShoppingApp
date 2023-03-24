package com.danielriverolosa.home.viewmodel

import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.ui.state.UiState
import com.danielriverolosa.core.ui.viewmodel.BaseViewModel
import com.danielriverolosa.home.action.HomeAction
import com.danielriverolosa.home.state.HomeUiState

class HomeViewModel(
    initialState: UiState<HomeUiState> = UiState.Loading
): BaseViewModel<HomeUiState, HomeAction>(initialState) {
    override fun handleAction(action: HomeAction) {
        when(action) {
            is HomeAction.Reload -> {
                UiState.Loading.emit()
            }
            is HomeAction.OnClickItem -> {
                HomeUiState(
                    listOf(Product("1", "Tomatoes", 1.20))
                ).emit()
            }
        }
    }
}