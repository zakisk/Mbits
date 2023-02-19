package com.example.mbits.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.mbits.MainViewModel
import com.example.mbits.ui.common_components.NavigationBack
import com.example.mbits.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    onBack: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Title(title = viewModel.screenTitle)
        },
        navigationIcon = {
            if (viewModel.isShowBack) {
                NavigationBack(tint = Color.White, onClick = onBack)
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_question_mark),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.White.copy(alpha = .5F)
        )
    )

}


@Composable
fun Title(title: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            color = Color.White
        ),
        textAlign = TextAlign.Center
    )
}