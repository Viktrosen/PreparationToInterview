package com.example.preparationtointerview

import android.app.Application
import com.example.preparationtointerview.di.AppComponent
import com.example.preparationtointerview.di.DaggerAppComponent

class App:Application() {
    companion object {
        lateinit var instance: App
            private set

        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.create()
    }
}