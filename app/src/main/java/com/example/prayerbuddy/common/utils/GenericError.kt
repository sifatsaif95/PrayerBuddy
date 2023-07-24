package com.example.prayerbuddy.common.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun GenericError(
    errorText: String,
    modifier: Modifier
) {
    if (errorText.isNotEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.Center
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Red,
                text = errorText
            )
        }
    }
}