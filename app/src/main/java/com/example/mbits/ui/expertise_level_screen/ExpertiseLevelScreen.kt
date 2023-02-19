package com.example.mbits.ui.expertise_level_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mbits.ui.expertise_level_screen.components.LevelListItem
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun ExpertiseLevelScreen(viewModel: ExpertiseLevelViewModel = hiltViewModel()) {
    val spacing = LocalSpacing.current
    LazyColumn {
        item {
            Text(
                text = "Select the Level based on experience",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(spacing.medium)
            )
        }

        itemsIndexed(viewModel.levels) { index, level ->
            LevelListItem(
                name = level,
                description = viewModel.descriptions[index],
                isSelected = viewModel.selected == level,
                onClick = { viewModel.setLevel(level) }
            )
        }
    }
}