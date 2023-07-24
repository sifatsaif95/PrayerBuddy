package com.example.prayerbuddy.ui

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.prayerbuddy.MainActivity
import com.example.prayerbuddy.presentation.ui.home.HomeScreen
import com.example.prayerbuddy.presentation.ui.theme.PrayerBuddyTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testDateColumn() {
        composeTestRule.activity.setContent {
            PrayerBuddyTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithTag("date_column_test_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("date_label_test_tag").assertTextEquals("Today:")
    }


    @Test
    fun testLocationColumn() {
        composeTestRule.activity.setContent {
            PrayerBuddyTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithTag("location_column_test_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("location_label_test_tag").assertTextEquals("Location:")
    }

    @Test
    fun testPrayerTimeColumn() {
        composeTestRule.activity.setContent {
            PrayerBuddyTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithTag("prayer_time_column_test_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("prayer_time_label_test_tag").assertTextEquals("Prayer:")
    }
}