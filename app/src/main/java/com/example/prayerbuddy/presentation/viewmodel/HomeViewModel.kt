package com.example.prayerbuddy.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prayerbuddy.common.utils.Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE
import com.example.prayerbuddy.common.utils.Result
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.usecase.GetPrayerTimesByDateAndAddressUseCase
import com.example.prayerbuddy.presentation.model.PrayerEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPrayerTimesByDateAndAddressUseCase: GetPrayerTimesByDateAndAddressUseCase
): ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    private val _data = MutableStateFlow(PrayerTimeEntity())
    val data: MutableStateFlow<PrayerTimeEntity> = _data

    private val _currentPrayer = MutableStateFlow(PrayerEntity())
    val currentPrayer: MutableStateFlow<PrayerEntity> = _currentPrayer

    private val _nextPrayer = MutableStateFlow(PrayerEntity())
    var nextPrayer: MutableStateFlow<PrayerEntity> = _nextPrayer

    fun getPrayerTimes() = viewModelScope.launch {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val currentDate: String = LocalDate.now().format(formatter)

        getPrayerTimesByDateAndAddressUseCase.invoke(date = currentDate, method = METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE, address = "110 Lathom Rd, London E6 2DY").collectLatest {
            when(it) {
                is Result.Loading -> {
                    _loading.value = true
                }
                is Result.Success -> {
                    _loading.value = false
                    _data.value = it.data
                    loadUIPrayerTimes(it.data)
                }
                is Result.Error -> {
                    _loading.value = false
                    _error.value = it.error
                }
            }
        }
    }

    private fun loadUIPrayerTimes(data: PrayerTimeEntity) {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val currentTime: String = LocalDateTime.now().format(formatter)

        if (currentTime >= data.fajr.time && currentTime < data.sunrise.time){
            currentPrayer.value = data.fajr
            nextPrayer.value = data.sunrise
        } else if (currentTime >= data.sunrise.time && currentTime < data.dhuhr.time){
            currentPrayer.value = data.sunrise
            nextPrayer.value = data.dhuhr
        } else if (currentTime >= data.dhuhr.time && currentTime < data.asr.time){
            currentPrayer.value = data.dhuhr
            nextPrayer.value = data.asr
        } else if (currentTime >= data.asr.time && currentTime < data.maghrib.time){
            currentPrayer.value = data.asr
            nextPrayer.value = data.maghrib
        } else if (currentTime >= data.maghrib.time && currentTime < data.isha.time){
            currentPrayer.value = data.maghrib
            nextPrayer.value = data.isha
        } else if (currentTime >= data.isha.time && currentTime < data.midnight.time){
            currentPrayer.value = data.isha
            nextPrayer.value = data.midnight
        } else if (currentTime >= data.midnight.time && currentTime < data.fajr.time){
            currentPrayer.value = data.midnight
            nextPrayer.value = data.fajr
        }
    }

    init {
        getPrayerTimes()
    }
}