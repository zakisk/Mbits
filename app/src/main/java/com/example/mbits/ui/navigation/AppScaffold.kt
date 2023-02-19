package com.example.mbits.ui.navigation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.mbits.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    viewModel: MainViewModel,
    navController: NavHostController,
) {

    Scaffold(
        topBar = {
            AppTopAppBar(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = viewModel.background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            AppNavHost(
                navController = navController,
                innerPadding = innerPadding
            )
        }
    }
}