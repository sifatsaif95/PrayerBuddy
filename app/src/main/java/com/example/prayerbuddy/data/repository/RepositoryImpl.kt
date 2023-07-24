package com.example.prayerbuddy.data.repository

import com.example.prayerbuddy.data.model.PrayerTimeResponse
import com.example.prayerbuddy.data.source.local.LocalDataSource
import com.example.prayerbuddy.data.source.remote.RemoteDataSource
import com.example.prayerbuddy.domain.entity.PrayerTimeEntity
import com.example.prayerbuddy.domain.mapper.PrayerTimeMapper
import com.example.prayerbuddy.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): Repository {
    override suspend fun getPrayerTimesByDateAndAddress(
        date: String,
        address: String,
        method: Int
    ): PrayerTimeEntity {
        return PrayerTimeMapper().toPrayerEntity(remoteDataSource.getPrayerTimesByDateAndAddress(date, address, method))
    }
}