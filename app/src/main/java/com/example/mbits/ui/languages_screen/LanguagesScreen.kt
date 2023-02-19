package com.example.mbits.ui.languages_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mbits.ui.common_components.ListItem
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun LanguagesScreen(viewModel: LanguagesViewModel = hiltViewModel()) {
    val spacing = LocalSpacing.current
    LazyColumn {
        item {
            Text(
                text = "Select the Language",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(spacing.medium)
            )
        }

        items(viewModel.languages) { language ->
            ListItem(
                name = language,
                isSelected = viewModel.selected == language,
                onClick = { viewModel.setLanguage(language) }
            )
        }
    }
}