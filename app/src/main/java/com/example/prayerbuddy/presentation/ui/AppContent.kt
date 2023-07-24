package com.example.prayerbuddy.presentation.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.prayerbuddy.presentation.ui.navigation.BottomNavBar
import com.example.prayerbuddy.presentation.ui.navigation.BottomNavItem
import com.example.prayerbuddy.presentation.ui.navigation.Navigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppContent(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
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