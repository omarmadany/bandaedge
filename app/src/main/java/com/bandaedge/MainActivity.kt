package com.bandaedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.bandaedge.presentation.screens.clock.ClockScreen
import com.bandaedge.core.theme.BandaedgeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BandaedgeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ClockScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}