package com.example.prayerbuddy.common.di

import com.example.prayerbuddy.data.api.ApiService
import com.example.prayerbuddy.data.api.RetrofitBuilder
import com.example.prayerbuddy.data.repository.RepositoryImpl
import com.example.prayerbuddy.data.source.local.LocalDataSource
import com.example.prayerbuddy.data.source.local.LocalDataSourceImpl
import com.example.prayerbuddy.data.source.remote.RemoteDataSource
import com.example.prayerbuddy.data.source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideService(): ApiService =
        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideLocalDataSource(): LocalDataSourceImpl = LocalDataSourceImpl()

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSourceImpl =
        RemoteDataSourceImpl(apiService)

    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    fun provideRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) =
        RepositoryImpl(localDataSource, remoteDataSource)
}