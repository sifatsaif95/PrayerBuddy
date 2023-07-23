package com.example.prayerbuddy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.usecase.GetPrayerTimesByDateAndAddressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.prayerbuddy.common.utils.Result

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

    fun getPrayerTimes() = viewModelScope.launch {
        getPrayerTimesByDateAndAddressUseCase.invoke(date = "22-07-2023", method = 15, address = "110 Lathom Rd, London E6 2DY").collectLatest {
            when(it) {
                is Result.Loading -> {
                    _loading.value = true
                }
                is Result.Success -> {
                    _loading.value = false
                    _data.value = it.data
                }
                is Result.Error -> {
                    _loading.value = false
                    _error.value = it.error
                }
            }
        }
    }

    init {
        getPrayerTimes()
    }
}