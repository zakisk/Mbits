package com.example.mbits.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mbits.ui.home_screen.components.CircularSlider
import com.example.mbits.ui.home_screen.components.Duration
import com.example.mbits.ui.home_screen.components.SheetContent
import com.hitfitapp.app.ui.theme.LocalSpacing
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val spacing = LocalSpacing.current
    val shape = MaterialTheme.shapes.medium
    var goalMinutes by remember { mutableStateOf(0) }
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        viewModel.setPrefs()
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            SheetContent(
                viewModel = viewModel,
                navigate = {
                    scope.launch { sheetState.hide() }
                    navController.navigate(it.route)
                }
            )
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = Color.Black.copy(alpha = .8F),
        scrimColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .padding(spacing.small)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = .7F), shape = shape),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularSlider(
                modifier = Modifier
                    .padding(top = spacing.medium)
                    .size(250.dp),
            ) {
                goalMinutes = (60 * it).toInt()
            }

            Row(
                modifier = Modifier
                    .padding(spacing.small)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Duration(duration = "40 Min", priority = "Recommended")
                Duration(
                    duration = "$goalMinutes Min", priority = "Goal",
                    lineBrush = Brush.linearGradient(
                        listOf(
                            Color(0xFFD84719), Color(0xFFE9661D), Color(0xFFD9DC31),
                            Color(0xFF3CC741), Color(0xFF84D6E1), Color(0xFF2C8EE9)
                        )
                    ),
                    onClick = {
                        scope.launch { sheetState.animateTo(ModalBottomSheetValue.Expanded) }
                    }
                )
                Duration(duration = "20 Min", priority = "Achieved")
            }
        }
    }
}