package com.example.prayerbuddy.common.di

import com.example.prayerbuddy.data.repository.RepositoryImpl
import com.example.prayerbuddy.data.source.local.LocalDataSource
import com.example.prayerbuddy.data.source.local.LocalDataSourceImpl
import com.example.prayerbuddy.data.source.remote.RemoteDataSource
import com.example.prayerbuddy.data.source.remote.RemoteDataSourceImpl
import com.example.prayerbuddy.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindLocalSource(localSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteSource(remoteSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}