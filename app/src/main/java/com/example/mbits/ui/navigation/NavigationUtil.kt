package com.example.mbits.ui.navigation

import android.content.Context
import androidx.navigation.NavDestination
import com.example.mbits.R


/**
 *  Returns the title of top app bar as per the current [NavDestination].
 *  @param context to get string resources.
 */
fun NavDestination.getTitle(context: Context): String {
    return when {
        Screen.HomeScreen.isEquals(route) -> context.getString(R.string.meditation_tool)
        Screen.InstructorsScreen.isEquals(route) -> context.getString(R.string.instructor)
        Screen.LanguagesScreen.isEquals(route) -> context.getString(R.string.language)
        Screen.ExpertiseLevelScreen.isEquals(route) -> context.getString(R.string.expert_level)
        else -> ""
    }
}


/**
 * Returns [Boolean] value whether the navigation back button should be shown or not as per current [NavDestination]
 */
fun NavDestination.isShowNavigationBack(): Boolean {
    return when {
        Screen.HomeScreen.isEquals(route) ||
        Screen.InstructorsScreen.isEquals(route) ||
        Screen.LanguagesScreen.isEquals(route) ||
        Screen.ExpertiseLevelScreen.isEquals(route) -> true
        else -> false
    }
}


fun NavDestination.getBackground() : Int {
    return when {
        Screen.HomeScreen.isEquals(route) -> R.drawable.home_background
        else -> R.drawable.list_background
    }
}

fun Screen.isEquals(route: String?): Boolean {
    return route?.contains(this.route, ignoreCase = true) == true
}