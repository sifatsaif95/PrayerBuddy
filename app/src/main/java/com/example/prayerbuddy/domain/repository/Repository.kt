package com.example.prayerbuddy.domain.repository

import com.example.prayerbuddy.domain.entity.PrayerTimeEntity

interface Repository {

    suspend fun getPrayerTimesByDateAndAddress(date: String, address: String, method: Int): PrayerTimeEntity
}