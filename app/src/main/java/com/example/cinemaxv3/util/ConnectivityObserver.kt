package com.example.cinemaxv3.util

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observer(): Flow<Status>

    enum class Status{
        Available, UnAvailable
    }
}