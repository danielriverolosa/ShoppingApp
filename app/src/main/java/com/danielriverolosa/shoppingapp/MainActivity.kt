@file:OptIn(ExperimentalMaterial3Api::class)

package com.danielriverolosa.shoppingapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.danielriverolosa.core.ui.theme.ShoppingAppTheme
import com.danielriverolosa.navigation.NavigationFactory
import com.danielriverolosa.navigation.NavigationRoute
import com.danielriverolosa.navigation.addNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationFactories: @JvmSuppressWildcards Set<NavigationFactory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShoppingApp()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun ShoppingApp() {
        val navController = rememberNavController()
        Scaffold {
            NavHost(navController = navController, startDestination = NavigationRoute.HOME) {
                navigationFactories.addNavigation(this, navController)
            }
        }
    }
}