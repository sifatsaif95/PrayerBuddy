package com.example.prayerbuddy.domain.repository

import com.example.prayerbuddy.data.model.PrayerTimeResponse

interface Repository {

    suspend fun getPrayerTimesByDateAndAddress(date: String, address: String, method: Int): PrayerTimeResponse
}