package com.cnm.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object CoreUtility {

    fun isInternetConnected(context: Context): Boolean {
        val connectivityManger =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManger.activeNetwork ?: return false
        val activeNw =
            connectivityManger.getNetworkCapabilities(networkCapabilities) ?: return false
        val result = when {
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return result


    }

}