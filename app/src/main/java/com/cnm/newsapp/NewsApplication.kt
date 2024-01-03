package com.cnm.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication :Application() {
    companion object{
        const val TAG = "NewsApplication"
    }
    override fun onCreate() {
        super.onCreate()
    }
}