package com.example.mbits.ui.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mbits.util.Constants.PREF_INSTRUCTOR
import com.example.mbits.util.Constants.PREF_LANGUAGE
import com.example.mbits.util.Constants.PREF_LEVEL
import com.example.mbits.util.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val prefStore: PrefStore
) : ViewModel() {

    var selectedInstructor by mutableStateOf("")
    var selectedLevel by mutableStateOf("")
    var selectedLanguage by mutableStateOf("")

    fun setPrefs() {
        selectedInstructor = prefStore.get<String>(PREF_INSTRUCTOR) ?: "Not selected"
        selectedLevel = prefStore.get<String>(PREF_LEVEL) ?: "Not selected"
        selectedLanguage = prefStore.get<String>(PREF_LANGUAGE) ?: "Not selected"
    }

}