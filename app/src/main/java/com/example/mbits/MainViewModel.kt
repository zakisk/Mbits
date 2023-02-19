package com.example.mbits

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDestination
import com.example.mbits.ui.navigation.getBackground
import com.example.mbits.ui.navigation.getTitle
import com.example.mbits.ui.navigation.isShowNavigationBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var screenTitle by mutableStateOf("")
    var isShowBack by mutableStateOf(false)
    var background by mutableStateOf(R.drawable.home_background)

    fun onDestinationChanged(context: Context, destination: NavDestination) {
        screenTitle = destination.getTitle(context)
        isShowBack = destination.isShowNavigationBack()
        background = destination.getBackground()
    }

}