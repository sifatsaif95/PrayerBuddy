package com.example.prayerbuddy.usecase

import com.example.prayerbuddy.common.PrayerEnum
import com.example.prayerbuddy.common.utils.Constants
import com.example.prayerbuddy.common.utils.Result
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.repository.Repository
import com.example.prayerbuddy.domain.usecase.GetPrayerTimesByDateAndAddressUseCase
import com.example.prayerbuddy.presentation.model.PrayerEntity
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetPrayerTimesByDateAndAddressUseCaseTest {
    @RelaxedMockK
    lateinit var repo: Repository

    private val coroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var getPrayerTimesByDateAndAddressUseCase: GetPrayerTimesByDateAndAddressUseCase

    private lateinit var prayerTimeEntity: PrayerTimeEntity

    @Before
    fun setUp() {
        Dispatchers.setMain(coroutineDispatcher)
        MockKAnnotations.init(this)
        getPrayerTimesByDateAndAddressUseCase =
            GetPrayerTimesByDateAndAddressUseCase(repo, coroutineDispatcher)
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
    fun `get prayer times on success`() {
        runTest {
            coEvery {
                repo.getPrayerTimesByDateAndAddress(
                    date = "23-07-2023",
                    method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE,
                    address = "110 Lathom Rd, London E6 2DY"
                )
            } returns prayerTimeEntity

            val data = getPrayerTimesByDateAndAddressUseCase.invoke(
                date = "23-07-2023",
                method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE,
                address = "110 Lathom Rd, London E6 2DY"
            )

            data.collectLatest {
                Truth.assertThat(it is Result.Success).isTrue()
            }
        }
    }

    @Test
    fun `get error on api failure`() {
        runTest {
            coEvery {
                repo.getPrayerTimesByDateAndAddress(
                    date = "23-07-2023",
                    method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE,
                    address = "110 Lathom Rd, London E6 2DY"
                )
            } returns PrayerTimeEntity()

            val data = getPrayerTimesByDateAndAddressUseCase.invoke(
                date = "23-07-2023",
                method = Constants.METHOD_MOONSIGHTING_COMMITTEE_WORLDWIDE,
                address = "110 Lathom Rd, London E6 2DY"
            )

            data.collectLatest {
                if (it is Result.Success) {
                    Truth.assertThat(it.data).isEqualTo(PrayerTimeEntity())
                }
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}