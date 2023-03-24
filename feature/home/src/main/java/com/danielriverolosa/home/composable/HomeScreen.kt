@file:OptIn(ExperimentalMaterial3Api::class)

package com.danielriverolosa.home.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.danielriverolosa.core.domain.entity.Product
import com.danielriverolosa.core.ui.state.UiState
import com.danielriverolosa.core.ui.state.handleUiState
import com.danielriverolosa.home.action.HomeAction
import com.danielriverolosa.home.state.HomeUiState
import com.danielriverolosa.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavHostController
) {
    Scaffold(
        topBar = { HomeAppBar() }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            viewModel.state.handleUiState(
                ContentScreen = { ContentUiState ->
                    HomeContentScreen(ContentUiState, viewModel::handleAction)
                }
            )
        }
    }
}

@Composable
fun HomeAppBar() {
    TopAppBar(
        title = {
            Text(text = "Shopping App")
        }
    )
}

@Composable
fun HomeContentScreen(state: HomeUiState, sendAction: (HomeAction) -> Unit) {
    LazyColumn {
        items(items = state.products, key = { it.id }) { product ->
            ProductItem(product, sendAction)
        }
    }
}

@Composable
fun ProductItem(product: Product, sendAction: (HomeAction) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { sendAction(HomeAction.OnClickItem) }
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = product.name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.width(32.dp))
        Text(text = product.price.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeContentScreen(
        state = HomeUiState(
            listOf(
                Product(1, "Tomatoes", 1.20)
            )
        ),
        sendAction = {}
    )
}