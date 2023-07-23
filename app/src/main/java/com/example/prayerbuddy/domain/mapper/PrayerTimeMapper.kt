package com.example.prayerbuddy.domain.mapper

import com.example.prayerbuddy.data.model.PrayerTimeResponse
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity

class PrayerTimeMapper {

    fun toPrayerEntity(response: PrayerTimeResponse): PrayerTimeEntity {
        return PrayerTimeEntity(
            gregorianDate = response.data.date.gregorian.date,
            hijriDate = response.data.date.hijri.date,
            asr = response.data.timings.Asr,
            dhuhr = response.data.timings.Dhuhr,
            fajr = response.data.timings.Fajr,
            firstthird = response.data.timings.Firstthird,
            imsak = response.data.timings.Imsak,
            isha = response.data.timings.Isha,
            lastthird = response.data.timings.Lastthird,
            maghrib = response.data.timings.Maghrib,
            midnight = response.data.timings.Midnight,
            sunrise = response.data.timings.Sunrise,
            sunset = response.data.timings.Sunset
        )
    }
}