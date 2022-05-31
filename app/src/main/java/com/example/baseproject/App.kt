package com.example.baseproject

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
    companion object {
        lateinit var mInstance: App
        fun getContext(): Context? {
            return mInstance.applicationContext
        }
    }
}