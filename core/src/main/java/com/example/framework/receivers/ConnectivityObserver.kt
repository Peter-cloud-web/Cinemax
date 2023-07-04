package com.example.framework.receivers

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observer(): Flow<Status>

    enum class Status{
        Available, UnAvailable
    }
}