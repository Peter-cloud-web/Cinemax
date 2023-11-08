package com.example.network

import com.example.network.TmdbHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun getHttpClient(): HttpClient {
        return TmdbHttpClient().getHttpClient()
    }
}








