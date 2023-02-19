package com.example.mbits.ui.languages_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mbits.util.Constants.PREF_LANGUAGE
import com.example.mbits.util.PrefStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LanguagesViewModel @Inject constructor(
    private val prefStore: PrefStore
) : ViewModel() {

    val languages =
        listOf("English", "Hindi", "Kannada", "Telugu", "Bengali")
    var selected by mutableStateOf(prefStore.get<String>(PREF_LANGUAGE) ?: "")

    fun setLanguage(language: String) {
        selected = language
        prefStore[PREF_LANGUAGE] = language
    }

}