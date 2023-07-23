package com.example.prayerbuddy.data.source.remote

import com.example.prayerbuddy.data.api.ApiService
import com.example.prayerbuddy.data.model.PrayerTimeResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): RemoteDataSource {
    override suspend fun getPrayerTimesByDateAndAddress(
        date: String,
        address: String,
        method: Int
    ): PrayerTimeResponse {
        return apiService.getPrayerTimesByAddress(date, address, method)
    }
}