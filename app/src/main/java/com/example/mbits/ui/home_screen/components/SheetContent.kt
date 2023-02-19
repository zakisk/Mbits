package com.example.mbits.ui.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mbits.R
import com.example.mbits.ui.home_screen.HomeViewModel
import com.example.mbits.ui.navigation.Screen
import com.example.mbits.ui.theme.Lochmara
import com.example.mbits.ui.theme.Malachite
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun SheetContent(viewModel: HomeViewModel, navigate: (Screen) -> Unit) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_bar),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(vertical = spacing.large)
        )

        Divider(color = Color.White, thickness = .3.dp)

        Row(
            modifier = Modifier
                .padding(horizontal = spacing.small)
                .fillMaxWidth()
        ) {
            SheetButton(
                modifier = Modifier.fillMaxWidth(.5F),
                iconId = R.drawable.ic_music,
                preference = "Music",
                selected = "Healing Energy"
            ) { }

            SheetButton(
                modifier = Modifier.fillMaxWidth(),
                iconId = R.drawable.ic_training,
                preference = "Instructor",
                selected = viewModel.selectedInstructor
            ) { navigate(Screen.InstructorsScreen) }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = spacing.small)
                .fillMaxWidth()
        ) {
            SheetButton(
                modifier = Modifier.fillMaxWidth(.5F),
                iconId = R.drawable.ic_level,
                preference = "Level",
                selected = viewModel.selectedLevel
            ) { navigate(Screen.ExpertiseLevelScreen) }

            SheetButton(
                modifier = Modifier.fillMaxWidth(),
                iconId = R.drawable.ic_language,
                preference = "Language",
                selected = viewModel.selectedLanguage
            ) { navigate(Screen.LanguagesScreen) }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = spacing.small)
                .fillMaxWidth()
        ) {
            SheetButton(
                modifier = Modifier.fillMaxWidth(.5F),
                iconId = R.drawable.ic_offline,
                preference = "Offline",
                selected = "2 Weeks"
            ) { }
        }

        Spacer(modifier = Modifier.height(spacing.small))

        Sunlight()

        Row(
            modifier = Modifier
                .padding(horizontal = spacing.small)
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .padding(horizontal = spacing.extraSmall)
                    .fillMaxWidth(.5F),
                text = "SCHEDULE",
                color = Color.Malachite
            )

            Button(
                modifier = Modifier
                    .padding(horizontal = spacing.extraSmall)
                    .fillMaxWidth(),
                text = "START",
                color = Color.Lochmara
            )
        }

        Spacer(modifier = Modifier.height(spacing.large))
    }
}

@Composable
fun Button(modifier: Modifier = Modifier, text: String, color: Color) {
    val shape = MaterialTheme.shapes.small
    val spacing = LocalSpacing.current
    Button(
        modifier = modifier,
        onClick = { },
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(vertical = spacing.small)
        )
    }
}