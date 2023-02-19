package com.example.mbits.ui.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun Duration(
    duration: String,
    priority: String,
    lineBrush: Brush = Brush.linearGradient(listOf(Color.White, Color.White)),
    onClick: () -> Unit = {},
) {
    val spacing = LocalSpacing.current
    var size by remember { mutableStateOf(Size.Zero) }
    val width: @Composable () -> Dp = { with(LocalDensity.current) { size.width.toDp() } }
    Column(
        modifier = Modifier
            .padding(horizontal = spacing.small, vertical = spacing.medium)
            .onGloballyPositioned { size = it.size.toSize() }
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource(),
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing.small)
    ) {
        Text(
            text = duration,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(
            modifier = Modifier
                .width(width())
                .height(3.dp)
                .background(brush = lineBrush, shape = CircleShape)
        )

        Text(
            text = priority,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
        )
    }
}