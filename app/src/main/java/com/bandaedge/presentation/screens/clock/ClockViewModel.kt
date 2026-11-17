package com.bandaedge.presentation.screens.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.seconds

// ── Constants ───────────────────────────────────────
private const val TIME_PATTERN = "HH:mm:ss"
private const val DATE_PATTERN = "dd / MM / yyyy"
private val TICK_INTERVAL = 1.seconds

// ── UI State ────────────────────────────────────────
data class ClockState(
    val time: String = "",
    val date: String = ""
)

// ── ViewModel ───────────────────────────────────────
class ClockViewModel : ViewModel() {

    private val timeFormatter = DateTimeFormatter.ofPattern(TIME_PATTERN)
    private val dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

    private val _state = MutableStateFlow(ClockState())
    val state: StateFlow<ClockState> = _state.asStateFlow()

    private var tickerJob: Job? = null

    init {
        startTicker()
    }

    // ── Ticker ──────────────────────────────────────
    private fun startTicker() {
        if (tickerJob?.isActive == true) return

        tickerJob = viewModelScope.launch {
            while (true) {
                publishCurrentTime()
                delay(TICK_INTERVAL)
            }
        }
    }

    // ── State Updates ───────────────────────────────
    private fun publishCurrentTime() {
        try {
            _state.value = buildClockState(LocalDateTime.now())
        } catch (cancellation: CancellationException) {
            throw cancellation
        } catch (_: Exception) {
            // Keep the last valid state so the UI never shows a broken clock.
        }
    }

    // ── Helper Functions ────────────────────────────
    private fun buildClockState(moment: LocalDateTime): ClockState = ClockState(
        time = moment.format(timeFormatter),
        date = moment.format(dateFormatter)
    )
}