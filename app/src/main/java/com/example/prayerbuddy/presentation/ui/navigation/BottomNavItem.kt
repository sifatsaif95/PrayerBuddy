package com.example.prayerbuddy.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        title = "Home",
        route = "home",
        icon = Icons.Default.Home
    )

    object Prayer : BottomNavItem(
        title = "Prayer",
        route = "prayer",
        icon = Icons.Default.Person
    )

    object Settings : BottomNavItem(
        title = "Settings",
        route = "settings",
        icon = Icons.Default.Settings
    )
}