package com.example.mbits.ui.expertise_level_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mbits.util.Constants
import com.example.mbits.util.Constants.PREF_LEVEL
import com.example.mbits.util.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ExpertiseLevelViewModel @Inject constructor(
    private val prefStore: PrefStore
) : ViewModel() {

    val levels =
        listOf("Beginner 1", "Beginner 2", "Intermediate", "Advance", "Expert")
    val descriptions = listOf(
        "The beginner 1  needs slow-paced direction and a great level of detail so they can become familiar with basic  use of the breath.",
        "The beginner 2 would like to explore their practice and begin to become more familiar with use of the breath. Becoming More Familiar",
        "The Intermediate are designed for those who have a good understanding of the basic yoga postures, and have begun to explore a wider variety of poses and styles.",
        "classes are designed for more experienced yogis with a very solid understanding of basic yoga postures who are comfortable performing more advanced poses.",
        "The advanced practices yoga regularly and has begun to master connection of breath with movement. Hard Work!"
    )
    var selected by mutableStateOf(prefStore.get<String>(PREF_LEVEL) ?: "")

    fun setLevel(level: String) {
        selected = level
        prefStore[PREF_LEVEL] = level
    }

}