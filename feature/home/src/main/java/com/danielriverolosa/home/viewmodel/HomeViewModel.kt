package com.danielriverolosa.home.viewmodel

import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.domain.usecase.product.GetProductListUseCase
import com.danielriverolosa.core.ui.action.UiAction
import com.danielriverolosa.core.ui.error.ErrorMessage
import com.danielriverolosa.core.ui.state.UiState
import com.danielriverolosa.core.ui.viewmodel.BaseViewModel
import com.danielriverolosa.home.action.HomeAction
import com.danielriverolosa.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) : BaseViewModel<HomeUiState, HomeAction>() {

    init {
        launch {
            getProductListUseCase(Unit)
                .onFailure(::mapToErrorState)
                .onSuccess{ HomeUiState(it).emit() }
        }
    }

    override fun handleAction(action: HomeAction) {
        when (action) {
            is HomeAction.Reload -> {
                UiState.Loading.emit()
            }
            is HomeAction.OnClickItem -> {
                HomeUiState(
                    listOf(Product(1, "Tomatoes", 1.20))
                ).emit()
            }
        }
    }
}