package com.danielriverolosa.home.factory

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danielriverolosa.home.composable.HomeScreen
import com.danielriverolosa.home.viewmodel.HomeViewModel
import com.danielriverolosa.navigation.NavigationFactory
import com.danielriverolosa.navigation.NavigationRoute
import com.danielriverolosa.navigation.viewModelComposable
import javax.inject.Inject

internal class HomeNavigationFactory @Inject constructor(): NavigationFactory {
    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.viewModelComposable<HomeViewModel>(
            NavigationRoute.HOME,
            content = {
                HomeScreen(
                    viewModel = this,
                    navController = navController
                )
            }
        )
    }
}