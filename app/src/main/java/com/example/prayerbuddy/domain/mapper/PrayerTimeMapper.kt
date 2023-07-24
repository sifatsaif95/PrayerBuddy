package com.example.prayerbuddy.domain.mapper

import com.example.prayerbuddy.common.PrayerEnum
import com.example.prayerbuddy.data.model.PrayerTimeResponse
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.presentation.model.PrayerEntity

class PrayerTimeMapper {

    fun toPrayerEntity(response: PrayerTimeResponse): PrayerTimeEntity {
        return PrayerTimeEntity(
            gregorianDate = response.data.date.gregorian.date,
            hijriDate = response.data.date.hijri.date,
            asr = PrayerEntity(name = PrayerEnum.ASR.prayerName, time = response.data.timings.Asr),
            dhuhr = PrayerEntity(name = PrayerEnum.DHUHR.prayerName, time = response.data.timings.Dhuhr),
            fajr = PrayerEntity(name = PrayerEnum.FAJR.prayerName, time = response.data.timings.Fajr),
            firstthird = PrayerEntity(name = PrayerEnum.FIRST_THIRD.prayerName, time = response.data.timings.Firstthird),
            imsak = PrayerEntity(name = PrayerEnum.IMSAK.prayerName, time = response.data.timings.Imsak),
            isha = PrayerEntity(name = PrayerEnum.ISHA.prayerName, time = response.data.timings.Isha),
            lastthird = PrayerEntity(name = PrayerEnum.LAST_THIRD.prayerName, time = response.data.timings.Lastthird),
            maghrib = PrayerEntity(name = PrayerEnum.MAGRIB.prayerName, time = response.data.timings.Maghrib),
            midnight = PrayerEntity(name = PrayerEnum.MIDNIGHT.prayerName, time = response.data.timings.Midnight),
            sunrise = PrayerEntity(name = PrayerEnum.SUNRISE.prayerName, time = response.data.timings.Sunrise),
            sunset = PrayerEntity(name = PrayerEnum.SUNSET.prayerName, time = response.data.timings.Sunset)
        )
    }
}