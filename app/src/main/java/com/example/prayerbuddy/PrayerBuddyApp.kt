package com.example.prayerbuddy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class PrayerBuddyApp @Inject constructor() : Application()