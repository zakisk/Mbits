package com.example.mbits.ui.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mbits.R
import com.example.mbits.ui.theme.Malachite
import com.hitfitapp.app.ui.theme.LocalSpacing


@Composable
fun Sunlight() {
    val spacing = LocalSpacing.current
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(spacing.medium)
            .background(color = Color.Gray.copy(alpha = .5F), shape = MaterialTheme.shapes.medium)
    ) {

        Icon(
            modifier = Modifier
                .padding(vertical = spacing.medium, horizontal = spacing.small)
                .size(20.dp),
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Column(
            modifier = Modifier
                .padding(vertical = spacing.medium, horizontal = spacing.small)
                .weight(1F),
            verticalArrangement = Arrangement.spacedBy(spacing.medium)
        ) {
            Text(
                text = "Sunlight",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )

            Text(
                text = stringResource(id = R.string.sunlight_description),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            )
        }

        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier
                .padding(spacing.small),
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Gray,
                checkedThumbColor = Color.Malachite,
                uncheckedTrackColor = Color.Gray,
                uncheckedThumbColor = Color.LightGray
            )
        )
    }
}