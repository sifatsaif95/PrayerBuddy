package com.example.prayerbuddy.common.di

import com.example.prayerbuddy.domain.repository.Repository
import com.example.prayerbuddy.domain.usecase.GetPrayerTimesByDateAndAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideGetPrayerTimesByDateAndAddressUseCase(repository: Repository, ioDispatcher: CoroutineDispatcher): GetPrayerTimesByDateAndAddressUseCase =
        GetPrayerTimesByDateAndAddressUseCase(repository, ioDispatcher)
}