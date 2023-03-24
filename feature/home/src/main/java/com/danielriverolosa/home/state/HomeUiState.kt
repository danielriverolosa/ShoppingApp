package com.danielriverolosa.home.state

import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.ui.state.UiContentState

class HomeUiState(
    val products: List<Product>
): UiContentState