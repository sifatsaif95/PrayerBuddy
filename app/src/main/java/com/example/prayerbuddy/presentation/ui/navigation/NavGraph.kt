package com.example.prayerbuddy.presentation.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prayerbuddy.presentation.ui.home.HomeScreen
import com.example.prayerbuddy.presentation.ui.prayer.PrayerScreen
import com.example.prayerbuddy.presentation.ui.settings.SettingsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(naController: NavHostController) {
    NavHost(navController = naController, startDestination = "home") {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Prayer.route) {
            PrayerScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}