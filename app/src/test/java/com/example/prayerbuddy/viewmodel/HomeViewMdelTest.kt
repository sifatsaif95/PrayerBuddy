package com.example.prayerbuddy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.prayerbuddy.common.PrayerEnum
import com.example.prayerbuddy.common.utils.Constants
import com.example.prayerbuddy.common.utils.Result
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.usecase.GetPrayerTimesByDateAndAddressUseCase
import com.example.prayerbuddy.presentation.model.PrayerEntity
import com.example.prayerbuddy.presentation.viewmodel.HomeViewModel
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewMdelTest {

    @get:Rule
    private val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    private val coroutineRule = TestCoroutineRule()

    private lateinit var prayerTimeEntity: PrayerTimeEntity

    private lateinit var viewmodel: HomeViewModel

    @RelaxedMockK
    private lateinit var getPrayerTimesByDateAndAddressUseCase: GetPrayerTimesByDateAndAddressUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewmodel = HomeViewModel(getPrayerTimesByDateAndAddressUseCase)
        prayerTimeEntity = PrayerTimeEntity(
            gregorianDate = "23-07-2023",
            hijriDate = "05-01-1445",
            asr = PrayerEntity(name = PrayerEnum.ASR.prayerName, time = "18:31"),
            dhuhr = PrayerEntity(name = PrayerEnum.DHUHR.prayerName, time = "13:06"),
            fajr = PrayerEntity(name = PrayerEnum.FAJR.prayerName, time = "02:43"),
            firstthird = PrayerEntity(name = PrayerEnum.FIRST_THIRD.prayerName, "23:45"),
            imsak = PrayerEntity(name = PrayerEnum.IMSAK.prayerName, time = "02:33"),
            isha = PrayerEntity(name = PrayerEnum.ISHA.prayerName, time = "23:21"),
            lastthird = PrayerEntity(name = PrayerEnum.LAST_THIRD.prayerName, time = "02:27"),
            maghrib = PrayerEntity(name = PrayerEnum.MAGRIB.prayerName, time = "21:03"),
            midnight = PrayerEntity(name = PrayerEnum.MIDNIGHT.prayerName, time = "01:06"),
            sunrise = PrayerEntity(name = PrayerEnum.SUNRISE.prayerName, time = "05:09"),
            sunset = PrayerEntity(name = PrayerEnum.SUNSET.prayerName, time = "21:03")
        )
    }

    @Test
    fun `test when api call is loading`() {
        coroutineRule.runBlockingTest {
            coEvery {
                getPrayerTimesByDateAndAddressUseCase.invoke(date = "23-07-2023", method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE, address = "110 Lathom Rd, London E6 2DY")
            } returns flow {
                emit(Result.Loading)
            }

            viewmodel.getPrayerTimes()

            Truth.assertThat(viewmodel.loading.value).isTrue()
            assertEquals(viewmodel.data.value.gregorianDate, "")
            assertEquals(viewmodel.data.value.asr.time, "")
            assertEquals(viewmodel.data.value.isha.time, "")
        }
    }

    @Test
    fun `test when api call is success`() {
        coroutineRule.runBlockingTest {
            coEvery {
                getPrayerTimesByDateAndAddressUseCase.invoke(date = "23-07-2023", method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE, address = "110 Lathom Rd, London E6 2DY")
            } returns flow {
                emit(Result.Success(prayerTimeEntity))
            }

            viewmodel.getPrayerTimes()

            Truth.assertThat(viewmodel.loading.value).isFalse()
            assertEquals(viewmodel.data.value, prayerTimeEntity)
        }
    }

    @Test
    fun `test when api call is failed`() {
        coroutineRule.runBlockingTest {
            coEvery {
                getPrayerTimesByDateAndAddressUseCase.invoke(date = "23-07-2023", method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE, address = "110 Lathom Rd, London E6 2DY")
            } returns flow {
                emit(Result.Error("Generic error"))
            }

            viewmodel.getPrayerTimes()

            Truth.assertThat(viewmodel.loading.value).isFalse()
            assertEquals(viewmodel.error.value, "Generic error")
            assertEquals(viewmodel.data.value.gregorianDate, "")
            assertEquals(viewmodel.data.value.asr.time, "")
            assertEquals(viewmodel.data.value.isha.time, "")
        }
    }
}