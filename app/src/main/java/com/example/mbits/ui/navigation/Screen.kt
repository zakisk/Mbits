package com.example.mbits.ui.navigation

sealed class Screen(val route: String) {

    object HomeScreen : Screen("home")

    object InstructorsScreen : Screen("instructors")

    object LanguagesScreen : Screen("languages")

    object ExpertiseLevelScreen : Screen("course_level")

}
