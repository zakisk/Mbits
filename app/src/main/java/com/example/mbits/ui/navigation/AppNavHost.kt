package com.example.mbits.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mbits.ui.expertise_level_screen.ExpertiseLevelScreen
import com.example.mbits.ui.home_screen.HomeScreen
import com.example.mbits.ui.instructors_screen.InstructorsScreen
import com.example.mbits.ui.languages_screen.LanguagesScreen


@Composable
fun AppNavHost(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.InstructorsScreen.route) {
            InstructorsScreen()
        }

        composable(Screen.LanguagesScreen.route) {
            LanguagesScreen()
        }

        composable(Screen.ExpertiseLevelScreen.route) {
            ExpertiseLevelScreen()
        }

    }

}