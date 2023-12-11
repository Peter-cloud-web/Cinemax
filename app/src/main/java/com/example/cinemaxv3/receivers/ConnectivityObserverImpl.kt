package com.example.cinemaxv3.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class ConnectivityObserverImpl(private val context: Context) : ConnectivityObserver {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkChangeReceiver = NetworkChangeReceiver()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun observer(): Flow<ConnectivityObserver.Status> {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(networkChangeReceiver, filter)

        return callbackFlow {
            val callback = object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    val networkInfo = connectivityManager.activeNetwork
                    val capabilities = connectivityManager.getNetworkCapabilities(networkInfo)

                    if (capabilities == null) {
                        launch { send(ConnectivityObserver.Status.UnAvailable) }
                    } else {
                        launch { send(ConnectivityObserver.Status.Available) }
                    }
                }
            }
            context.registerReceiver(callback, filter)
            awaitClose {
                context.unregisterReceiver(callback)
            }

        }.distinctUntilChanged()

    }
}