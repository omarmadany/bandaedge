package com.bandaedge.presentation.screens.clock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// ── Constants ───────────────────────────────────────
private val ScreenHorizontalPadding = 16.dp
private val DateTopSpacing = 8.dp

// ── Screen ──────────────────────────────────────────
@Composable
fun ClockScreen(
    modifier: Modifier = Modifier,
    viewModel: ClockViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    ClockContent(
        state = state,
        modifier = modifier
    )
}

// ── UI Components ───────────────────────────────────
@Composable
private fun ClockContent(
    state: ClockState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = ScreenHorizontalPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeText(time = state.time)
        DateText(date = state.date)
    }
}

@Composable
private fun TimeText(time: String) {
    Text(
        text = time,
        style = MaterialTheme.typography.displayLarge,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        maxLines = 1
    )
}

@Composable
private fun DateText(date: String) {
    Text(
        text = date,
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        maxLines = 1,
        modifier = Modifier.padding(top = DateTopSpacing)
    )
}