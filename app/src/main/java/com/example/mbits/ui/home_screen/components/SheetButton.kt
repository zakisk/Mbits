package com.example.mbits.ui.home_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun SheetButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    preference: String,
    selected: String,
    onClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .padding(spacing.small)
            .background(color = Color.Gray.copy(alpha = .5F), shape = MaterialTheme.shapes.medium)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onClick
            )
    ) {

        Icon(
            modifier = Modifier
                .padding(vertical = spacing.medium, horizontal = spacing.small)
                .size(20.dp),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.White,
        )

        Column(
            modifier = Modifier.padding(vertical = spacing.medium, horizontal = spacing.small),
            verticalArrangement = Arrangement.spacedBy(spacing.medium)
        ) {
            Text(
                text = preference,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )

            Text(
                text = selected,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}