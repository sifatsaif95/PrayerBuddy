package com.example.prayerbuddy.domain.usecase

import com.example.prayerbuddy.common.utils.Result
import com.example.prayerbuddy.common.utils.flowResourceUseCase
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.mapper.PrayerTimeMapper
import com.example.prayerbuddy.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPrayerTimesByDateAndAddressUseCase @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(
        date: String,
        address: String,
        method: Int
    ): Flow<Result<PrayerTimeEntity>> {
        return flowResourceUseCase {
            repository.getPrayerTimesByDateAndAddress(date, address, method)
        }.flowOn(dispatcher)
    }
}