package com.example.prayerbuddy.domain.entity

import com.example.prayerbuddy.presentation.model.PrayerEntity

data class PrayerTimeEntity(
    val gregorianDate: String = "",
    val hijriDate: String = "",
    val asr: PrayerEntity = PrayerEntity(),
    val dhuhr: PrayerEntity = PrayerEntity(),
    val fajr: PrayerEntity = PrayerEntity(),
    val firstthird: PrayerEntity = PrayerEntity(),
    val imsak: PrayerEntity = PrayerEntity(),
    val isha: PrayerEntity = PrayerEntity(),
    val lastthird: PrayerEntity = PrayerEntity(),
    val maghrib: PrayerEntity = PrayerEntity(),
    val midnight: PrayerEntity = PrayerEntity(),
    val sunrise: PrayerEntity = PrayerEntity(),
    val sunset: PrayerEntity = PrayerEntity()
)
