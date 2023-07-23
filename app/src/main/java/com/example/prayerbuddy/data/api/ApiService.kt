package com.example.prayerbuddy.data.api

import com.example.prayerbuddy.data.model.PrayerTimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/timingsByAddress/{date}")
    suspend fun getPrayerTimesByAddress(@Path("date") date: String, @Query("address") address: String, @Query("method") method: Int): PrayerTimeResponse
}