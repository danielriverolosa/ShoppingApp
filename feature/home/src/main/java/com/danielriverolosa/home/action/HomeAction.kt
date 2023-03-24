package com.danielriverolosa.home.action

import com.danielriverolosa.core.ui.action.UiAction

sealed interface HomeAction: UiAction {
    object Reload: HomeAction
    object OnClickItem: HomeAction
}