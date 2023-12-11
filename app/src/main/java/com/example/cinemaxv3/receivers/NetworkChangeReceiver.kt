package com.example.cinemaxv3.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_ETHERNET
import android.net.NetworkCapabilities.TRANSPORT_WIFI

class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(networkInfo)


        if (capabilities == null || !capabilities.hasTransport(TRANSPORT_WIFI) || !capabilities.hasTransport(
                TRANSPORT_ETHERNET
            ) || !capabilities.hasTransport(TRANSPORT_CELLULAR)
        ) {
//            launch { send(ConnectivityObserver.Status.UnAvailable) }
        }
    }
}
