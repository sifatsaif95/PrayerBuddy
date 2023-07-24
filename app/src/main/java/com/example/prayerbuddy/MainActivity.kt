package com.example.prayerbuddy

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.prayerbuddy.presentation.ui.navigation.BottomNavBar
import com.example.prayerbuddy.presentation.ui.navigation.BottomNavItem
import com.example.prayerbuddy.presentation.ui.navigation.Navigation
import com.example.prayerbuddy.presentation.ui.theme.PrayerBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrayerBuddyTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavBar(
                            items = listOf(
                                BottomNavItem.Home,
                                BottomNavItem.Prayer,
                                BottomNavItem.Settings
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(naController = navController)
                }
            }
        }
    }
}
