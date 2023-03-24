package com.danielriverolosa.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavigationFactory {
    fun create(builder: NavGraphBuilder, navController: NavHostController)
}

fun Iterable<NavigationFactory>.addNavigation(
    builder: NavGraphBuilder,
    navController: NavHostController
) {
    forEach { factory ->
        factory.create(builder, navController)
    }
}