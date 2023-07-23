package com.example.prayerbuddy.data.source.remote

import com.example.prayerbuddy.data.model.PrayerTimeResponse
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteDataSource {
    suspend fun getPrayerTimesByDateAndAddress(date: String, address: String, method: Int): PrayerTimeResponse
}