package com.example.cinemaxv3.receivers

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observer(): Flow<Status>

    enum class Status{
        Available, UnAvailable
    }
}