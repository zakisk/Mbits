package com.example.mbits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.mbits.ui.navigation.AppScaffold
import com.example.mbits.ui.theme.MbitsApp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbitsApp {
                val navController = rememberNavController()
                AppScaffold(navController = navController, viewModel = viewModel)
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    viewModel.onDestinationChanged(this, destination)
                }
            }
        }
    }
}