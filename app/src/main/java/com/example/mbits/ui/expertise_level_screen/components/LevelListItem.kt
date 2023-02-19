package com.example.mbits.ui.expertise_level_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.mbits.R
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun LevelListItem(name: String, description: String, isSelected: Boolean, onClick: () -> Unit) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .padding(horizontal = spacing.medium, vertical = spacing.small)
            .fillMaxWidth()
            .background(
                color = if (isSelected) Color.White.copy(alpha = .5F) else Color.Black.copy(alpha = .5F),
                shape = MaterialTheme.shapes.medium
            )
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource(),
                onClick = onClick
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = spacing.medium, vertical = spacing.small)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            if (isSelected) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_selected),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }

        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
            modifier = Modifier
                .padding(horizontal = spacing.medium, vertical = spacing.small)
                .fillMaxWidth()
        )
    }
}