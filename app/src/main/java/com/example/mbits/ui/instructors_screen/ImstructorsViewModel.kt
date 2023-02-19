package com.example.mbits.ui.instructors_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mbits.util.Constants.PREF_INSTRUCTOR
import com.example.mbits.util.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class InstructorsViewModel @Inject constructor(
    private val prefStore: PrefStore,
) : ViewModel() {

    val instructors =
        listOf("Darlene Robertson", "Ronald Richards", "Guy Hawkins", "Robert Fox")
    var selected by mutableStateOf(prefStore.get<String>(PREF_INSTRUCTOR) ?: "")

    fun setInstructor(instructor: String) {
        selected = instructor
        prefStore[PREF_INSTRUCTOR] = instructor
    }

}