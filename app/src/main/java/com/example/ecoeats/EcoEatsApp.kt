package com.example.ecoeats

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.security.spec.ECField

@HiltAndroidApp
class EcoEatsApp:Application() {

    companion object {
        @JvmStatic
        var instance: EcoEatsApp? = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}